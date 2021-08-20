package com.example.rising_test_yanolja.src.main.area.station

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.BaseFragment
import com.example.rising_test_yanolja.databinding.FragmentAreaStationBinding
import com.example.rising_test_yanolja.databinding.FragmentAreaStationCapitalBinding
import com.example.rising_test_yanolja.src.main.area.map.AreaMapFragment
import com.example.rising_test_yanolja.src.main.area.station.busan.AreaStationBusanFragment
import com.example.rising_test_yanolja.src.main.area.station.capital.AreaStationCapitalFragment
import com.example.rising_test_yanolja.src.main.area.station.daegu.AreaStationDaeguFragment
import com.example.rising_test_yanolja.src.main.area.station.daejeon.AreaStationDaejeonFragment
import com.example.rising_test_yanolja.src.main.area.station.gwangju.AreaStationGwangjuFragment
import com.google.android.material.tabs.TabLayout

class AreaStationFragment : BaseFragment<FragmentAreaStationBinding>(FragmentAreaStationBinding::bind, R.layout.fragment_area_station){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //tabLayout의 tab사이에 마진 주는 방법
        for (i in 0 until binding.mainAreaStationTabLayout.getTabCount()) {
            val tab = (binding.mainAreaStationTabLayout.getChildAt(0) as ViewGroup).getChildAt(i)
            val p = tab.layoutParams as ViewGroup.MarginLayoutParams
            p.setMargins(10, 25, 10, 25)
            tab.requestLayout()
        }

        //tabLayout 시작과 끝 마진 더 줌
        var tabStart = (binding.mainAreaStationTabLayout.getChildAt(0) as ViewGroup).getChildAt(0)
        var tabEnd = (binding.mainAreaStationTabLayout.getChildAt(0) as ViewGroup).getChildAt(4)
        var pStart = tabStart.layoutParams as ViewGroup.MarginLayoutParams
        var pEnd = tabEnd.layoutParams as ViewGroup.MarginLayoutParams
        pStart.setMargins(20,25,10,25)
        pEnd.setMargins(10,25,20,25)
        tabEnd.requestLayout()
        tabStart.requestLayout()


        //기본으로 수도권이 나오도록 셋팅
        childFragmentManager.beginTransaction().replace(R.id.main_area_station_frameLayout,AreaStationCapitalFragment()).commitAllowingStateLoss()



        //tabLayout에 클릭 리스너 달아줌
            binding.mainAreaStationTabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    when (tab!!.position) {
                        0-> childFragmentManager.beginTransaction().replace(R.id.main_area_station_frameLayout,AreaStationCapitalFragment()).commitAllowingStateLoss()
                        1-> childFragmentManager.beginTransaction().replace(R.id.main_area_station_frameLayout,AreaStationBusanFragment()).commitAllowingStateLoss()
                        2-> childFragmentManager.beginTransaction().replace(R.id.main_area_station_frameLayout,AreaStationDaeguFragment()).commitAllowingStateLoss()
                        3-> childFragmentManager.beginTransaction().replace(R.id.main_area_station_frameLayout,AreaStationGwangjuFragment()).commitAllowingStateLoss()
                        4-> childFragmentManager.beginTransaction().replace(R.id.main_area_station_frameLayout,AreaStationDaejeonFragment()).commitAllowingStateLoss()
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                }
            })

    }
}