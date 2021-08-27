package com.example.rising_test_yanolja.src.main.myYanolja.myInfo

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View

import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.ApplicationClass
import com.example.rising_test_yanolja.config.ApplicationClass.Companion.sSharedPreferences
import com.example.rising_test_yanolja.config.BaseActivity
import com.example.rising_test_yanolja.config.BaseResponse
import com.example.rising_test_yanolja.databinding.ActivityMyInfoBinding
import com.example.rising_test_yanolja.src.main.MainActivity
import com.example.rising_test_yanolja.src.main.myYanolja.myInfo.models.MyInfoResponse
import com.example.rising_test_yanolja.src.main.myYanolja.myInfo.models.PostChangeUserRequest

class MyInfoActivity : BaseActivity<ActivityMyInfoBinding>(ActivityMyInfoBinding::inflate),MyInfoActivityView {

    private lateinit var JWT : String
    private var nickName = " "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        JWT = ApplicationClass.sSharedPreferences.getString("X_ACCESS_TOKEN","").toString()


        nickName= sSharedPreferences.getString("nickName","").toString()

        binding.myInfoTxNickname.text=nickName

        //사용자 이메일 핸펀 불러오기
        MyInfoService(this).tryGetUserEmailPhone(JWT)


        binding.myInfoBtnPencel.setOnClickListener {
                binding.constraint2.visibility= View.GONE
                binding.constraint3.visibility=View.VISIBLE
        }
        binding.myInfoBtnCancel.setOnClickListener {
            binding.constraint2.visibility= View.VISIBLE
            binding.constraint3.visibility=View.GONE
        }



        //edtText 체인지 리스너
        binding.myInfoEdtNickName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(binding.myInfoEdtNickName.length()!=0){
                    binding.myInfoBtnNickReset.visibility=View.VISIBLE
                    binding.myInfoTxError.visibility=View.INVISIBLE
                }else{
                    binding.myInfoBtnNickReset.visibility=View.INVISIBLE
                    binding.myInfoTxError.visibility=View.VISIBLE
                }
                if(binding.myInfoEdtNickName.length()>1){
                    binding.myInfoBtnChangeNickname.setBackgroundResource(R.drawable.my_info_gray_stroke_btn_ok_round)
                    binding.myInfoBtnChangeNickname.setTextColor(getColor(R.color.darkGray))
                    binding.myInfoBtnChangeNickname.isClickable=true
                }else{
                    binding.myInfoBtnChangeNickname.setBackgroundResource(R.drawable.my_info_gray_stroke_btn_round)
                    binding.myInfoBtnChangeNickname.setTextColor(getColor(R.color.tabTextGray))
                    binding.myInfoBtnChangeNickname.isClickable=false
                }


            }
            override fun afterTextChanged(s: Editable?) {
            }
        })



        //확인 버튼 클릭 리스너
        binding.myInfoBtnChangeNickname.setOnClickListener {
            MyInfoService(this).tryPostChangeUser(JWT, PostChangeUserRequest(binding.myInfoEdtNickName.text.toString()))
        }

    }

    override fun onGetUserEmailPhoneSuccess(response: MyInfoResponse) {
        if (response.code==1000){
            binding.email1.text=response.result[0].email
            binding.email3.text=response.result[0].email
            binding.email2.text=response.result[0].email
            binding.phone.text=response.result[0].phoneNum
        }
    }

    override fun onGetUserEmailPhoneFailure(message: String) {
    }



    //닉네임 수정 api 통신 성공
    override fun onPostChangeUserNicknameSuccess(response: BaseResponse) {

        if(response.isSuccess){
            var editor = sSharedPreferences.edit()
            editor.putString("nickName",binding.myInfoEdtNickName.text.toString())
            editor.apply()

            var intent = Intent(this, MyInfoActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
    //닉네임 수정 api 통신 실패
    override fun onPostChangeUserNicknameFailure(message: String) {
        showCustomToast(message)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        var intent = Intent(this,MainActivity::class.java)
        intent.putExtra("currentViewPagerIndex",4)
        startActivity(intent)
        finish()
    }


}