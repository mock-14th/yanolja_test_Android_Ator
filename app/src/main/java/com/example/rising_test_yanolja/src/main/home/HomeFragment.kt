package com.example.rising_test_yanolja.src.main.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.databinding.FragmentHomeBinding
import com.example.rising_test_yanolja.src.main.home.enjoy.HomeEnjoyFragment
import com.example.rising_test_yanolja.src.main.home.internalRoom.HomeInternalRoomFragment
import com.example.rising_test_yanolja.src.main.home.overseasTrip.HomeOverseasTripFragment
import com.example.rising_test_yanolja.src.main.home.recommend.HomeRecommendFragment
import com.example.rising_test_yanolja.src.main.home.traffic.HomeTrafficFragment
import com.google.android.material.tabs.TabLayoutMediator
import com.softsquared.template.kotlin.config.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding> (FragmentHomeBinding::bind, R.layout.fragment_home){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var fragmentList = ArrayList<Fragment>()
        fragmentList.add(HomeRecommendFragment())
        fragmentList.add(HomeInternalRoomFragment())
        fragmentList.add(HomeEnjoyFragment())
        fragmentList.add(HomeTrafficFragment())
        fragmentList.add(HomeOverseasTripFragment())

        //tabLayout 타이틀에 들어갈 배열
        val tabTitleList = arrayListOf<String>("추천","국내숙소","즐길거리","교통/항공","해외여행")

        binding.mainHomeViewPager2.adapter = HomeViewPager2Adapter(this)
        binding.mainHomeViewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        TabLayoutMediator(binding.mainHomeTabLayout,binding.mainHomeViewPager2){ tab, position ->
            tab.text = tabTitleList[position]
        }.attach()
    }

}