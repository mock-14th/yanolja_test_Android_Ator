package com.example.rising_test_yanolja.src.main.myYanolja.checkPassword

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.content.ContextCompat
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.ApplicationClass
import com.example.rising_test_yanolja.config.BaseActivity
import com.example.rising_test_yanolja.config.BaseResponse
import com.example.rising_test_yanolja.databinding.ActivityCheckPasswordBinding
import com.example.rising_test_yanolja.src.main.myYanolja.checkPassword.models.PostCheckPasswordRequest
import com.example.rising_test_yanolja.src.main.myYanolja.myInfo.MyInfoActivity

class CheckPasswordMyInfoActivity : BaseActivity<ActivityCheckPasswordBinding>(ActivityCheckPasswordBinding::inflate),CheckPasswordMyInfoActivityView {

    private lateinit var JWT : String
    private var nickName = " "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        JWT = ApplicationClass.sSharedPreferences.getString("X_ACCESS_TOKEN","").toString()
        nickName = intent.getStringExtra("nickName").toString()

        //확인 버튼 클릭 리스너
        binding.checkPasswordBtnOk.setOnClickListener {
            CheckPasswordService(this).tryPostCheckPassword(JWT, PostCheckPasswordRequest(binding.checkPasswordEdtPwd.text.toString()))
        }



        //edt pwd의 텍스트 체인지 리스너
        binding.checkPasswordEdtPwd.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.checkPasswordTxError.visibility=View.INVISIBLE
                binding.checkPasswordEdtPwd.backgroundTintList = ContextCompat.getColorStateList(applicationContext, R.color.tabTextGray)

                binding.checkPasswordBtnOk.isEnabled = binding.checkPasswordEdtPwd.length()!=0
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

    }

    override fun onPostCheckPasswordSuccess(response: BaseResponse) {
        when(response.code){
            1001->{ //비밀번호 인증성공
                var intent = Intent(this,MyInfoActivity::class.java)
                intent.putExtra("nickName",nickName)
                startActivity(intent)
            }
            3004->{//비밀번호가 잘못되었따.
                binding.checkPasswordEdtPwd.backgroundTintList = ContextCompat.getColorStateList(applicationContext, R.color.red)
                binding.checkPasswordTxError.visibility= View.VISIBLE
            }
        }
    }

    override fun onPostCheckPasswordFailure(message: String) {
    }
}