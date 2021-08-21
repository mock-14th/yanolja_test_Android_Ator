package com.example.rising_test_yanolja.src.main.myNear

import android.os.Bundle
import android.view.View
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.BaseFragment
import com.example.rising_test_yanolja.databinding.FragmentLikeBinding
import com.example.rising_test_yanolja.databinding.FragmentMyNearBinding
import com.example.rising_test_yanolja.src.main.myNear.sub.MyNearSubFragment

class MyNearFragment : BaseFragment<FragmentMyNearBinding>(FragmentMyNearBinding::bind, R.layout.fragment_my_near) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        childFragmentManager.beginTransaction().add(R.id.main_my_near_frameLayout,MyNearSubFragment()).commitAllowingStateLoss()

    }
}