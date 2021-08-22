package com.example.rising_test_yanolja.src.main.myNear.sub

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.BaseFragment
import com.example.rising_test_yanolja.databinding.FragmentMyNearSubBinding
import com.example.rising_test_yanolja.src.main.home.HomeViewPager2Adapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MyNearSubFragment : BaseFragment<FragmentMyNearSubBinding>(FragmentMyNearSubBinding::bind, R.layout.fragment_my_near_sub) {

    var tabTitleList = arrayOf("모텔","호텔/리조트","펜션/풀빌라","게스트하우스","#무한쿠폰룸","#부티크브랜드")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainMyNearSubViewPager.adapter = MyNearSubViewPager2Adapter(this)
        binding.mainMyNearSubViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        TabLayoutMediator(binding.mainMyNearSubTabLayout,binding.mainMyNearSubViewPager){ tab, position ->
            tab.text = tabTitleList[position]
        }.attach()
    }
}