package com.example.rising_test_yanolja.src.main.myYanolja

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.ApplicationClass.Companion.sSharedPreferences
import com.example.rising_test_yanolja.config.BaseFragment
import com.example.rising_test_yanolja.databinding.FragmentMyYanoljaBinding
import com.example.rising_test_yanolja.src.login.LoginActivity
import com.example.rising_test_yanolja.src.main.myYanolja.models.MyYanoljaResponse
import com.example.rising_test_yanolja.src.setting.SettingActivity

class MyYanoljaFragment : BaseFragment<FragmentMyYanoljaBinding>(FragmentMyYanoljaBinding::bind, R.layout.fragment_my_yanolja),MyYanoljaFragmentView {

    private lateinit var JWT : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        JWT = sSharedPreferences.getString("X_ACCESS_TOKEN","").toString()

        //JWT토큰 확인하고 있다면, 해당 토큰의 정보를 서버에서 불러온다.
        if(!JWT.isEmpty())
            MyYanoljaService(this).tryGetMyYanoljaInfo(JWT)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //JWT의 여부를 물어보고 만약 JWTW가 있다면 로그인 했을 경우의 화면을 visible해주고 비어있다면, 로그인 할 수 있는 화면의 클릭 리스너를 달아준다.
        if (JWT.isEmpty()){
            binding.mainMyYanoljaBtnLoginBefore.setOnClickListener {
                var intent = Intent(context, LoginActivity::class.java)
                intent.putExtra("currentViewPagerIndex",4)
                startActivity(intent)
            }
        }else{
            binding.mainMyYanoljaLoginLinear.visibility=View.INVISIBLE
            binding.mainMyYanoljaLoginLinearHasJWT.visibility=View.VISIBLE
        }


        //appbarlayout의 그림자 효과를 스크롤 최상단에서만 주기 위한 코드
        binding.mainMyYanoljaNestedscrollview.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if(scrollY == 0){
                binding.mainMyYanoljaAppbarLayout.translationZ =0f
            }else
                binding.mainMyYanoljaAppbarLayout.translationZ =7f
        }



        //설정 버튼 클릭 리스너
        binding.mainMyYanoljaBtnSetting.setOnClickListener {
            var intent = Intent(context,SettingActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onGetMyYanoljaInfoSuccess(response: MyYanoljaResponse) {
        if(response.isSuccess){
            binding.mainMyYanoljaTxNicknameHasJWT.text=response.result.nickname
            binding.mainMyYanoljaTxPointHasJWT.text=response.result.point
            binding.mainMyYanoljaTxCoinHasJWT.text=response.result.coin
            binding.mainMyYanoljaTxCouponCountHasJWT.text=response.result.coupon.toString()
        }

    }

    override fun onGetMyYanoljaInffoFailure(message: String) {
        showCustomToast("오류 : $message")
    }
}