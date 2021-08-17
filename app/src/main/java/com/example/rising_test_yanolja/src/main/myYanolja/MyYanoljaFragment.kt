package com.example.rising_test_yanolja.src.main.myYanolja

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.databinding.FragmentMyYanoljaBinding
import com.example.rising_test_yanolja.src.login.LoginActivity
import com.google.android.material.appbar.AppBarLayout
import com.softsquared.template.kotlin.config.BaseFragment

class MyYanoljaFragment : BaseFragment<FragmentMyYanoljaBinding>(FragmentMyYanoljaBinding::bind, R.layout.fragment_my_yanolja) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainMyYanoljaBtnLoginBefore.setOnClickListener {
            var intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
        }


        //appbarlayout의 그림자 효과를 스크롤 최상단에서만 주기 위한 코드
        binding.mainMyYanoljaNestedscrollview.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if(scrollY == 0){
                binding.mainMyYanoljaAppbarLayout.translationZ =0f
            }else
                binding.mainMyYanoljaAppbarLayout.translationZ =7f
        }


    }
}