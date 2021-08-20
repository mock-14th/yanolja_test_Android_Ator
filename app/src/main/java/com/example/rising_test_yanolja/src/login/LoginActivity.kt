package com.example.rising_test_yanolja.src.login

import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.text.method.SingleLineTransformationMethod
import android.view.View
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.BaseActivity
import com.example.rising_test_yanolja.databinding.ActivityLoginBinding
import com.example.rising_test_yanolja.src.login.simple.SimpleLoginFragment
import com.example.rising_test_yanolja.src.login.yanolja.YanoljaLoginFragment
import com.google.android.material.tabs.TabLayout

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {
    private var fmYanoljaLogin : YanoljaLoginFragment? = null
    private var fmSimpleLogin : SimpleLoginFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var requestViewPagerPosition = intent.getIntExtra("currentViewPagerIndex",0)


        //activity로 부터 받은 viewpager index값을 넘겨준다.
        fmYanoljaLogin = YanoljaLoginFragment()
        var bundle = Bundle()
        bundle.putInt("currentViewPagerIndex",requestViewPagerPosition)
        fmYanoljaLogin!!.arguments = bundle
        supportFragmentManager.beginTransaction().add(R.id.login_frameLayout,fmYanoljaLogin!!).commitAllowingStateLoss()


        //tabLayout누르면 frameLayout의 fragment를 교체해 주는 코드 기존의 fragment가 유지될 수 있도록 구현했다.
        binding.loginTabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab!!.position){
                    0-> {
                        supportFragmentManager.beginTransaction().show(fmYanoljaLogin!!).commitAllowingStateLoss()
                        supportFragmentManager.beginTransaction().hide(fmSimpleLogin!!).commitAllowingStateLoss()
                    }
                    1->{
                        if(fmSimpleLogin==null) {
                            fmSimpleLogin = SimpleLoginFragment()
                            supportFragmentManager.beginTransaction().add(R.id.login_frameLayout, fmSimpleLogin!!).commitAllowingStateLoss()
                            supportFragmentManager.beginTransaction().hide(fmYanoljaLogin!!).commitAllowingStateLoss()
                        } else{
                            supportFragmentManager.beginTransaction().hide(fmYanoljaLogin!!).commitAllowingStateLoss()
                            supportFragmentManager.beginTransaction().show(fmSimpleLogin!!).commitAllowingStateLoss()
                        }

                    }
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })


        //뒤로가기 이미지 버튼 클릭 리스너
        binding.loginBtnBack.setOnClickListener {
            this.finish()
        }

    }
}