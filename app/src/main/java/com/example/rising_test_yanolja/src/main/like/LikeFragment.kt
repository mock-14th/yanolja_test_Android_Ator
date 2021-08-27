package com.example.rising_test_yanolja.src.main.like

import android.os.Bundle
import android.view.View
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.ApplicationClass
import com.example.rising_test_yanolja.config.BaseFragment
import com.example.rising_test_yanolja.databinding.FragmentLikeBinding

class LikeFragment : BaseFragment<FragmentLikeBinding>(FragmentLikeBinding::bind, R.layout.fragment_like) {

    private lateinit var fmLikeNoLoginFunctionalInterface : LikeNoLoginFragment
    private lateinit var fmLikeLoginFunctionalInterface : LikeLoginFragment
    private lateinit var JWT : String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        JWT = ApplicationClass.sSharedPreferences.getString("X_ACCESS_TOKEN","").toString()

        if(!JWT.isEmpty()){
            fmLikeLoginFunctionalInterface = LikeLoginFragment()
            childFragmentManager.beginTransaction().replace(R.id.main_like_frameLayout,fmLikeLoginFunctionalInterface!!).commitAllowingStateLoss()
        }else{
            fmLikeNoLoginFunctionalInterface = LikeNoLoginFragment()
            childFragmentManager.beginTransaction().add(R.id.main_like_frameLayout,fmLikeNoLoginFunctionalInterface!!).commitAllowingStateLoss()
        }
    }
}