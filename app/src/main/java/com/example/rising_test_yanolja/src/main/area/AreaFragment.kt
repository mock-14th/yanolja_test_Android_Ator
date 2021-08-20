package com.example.rising_test_yanolja.src.main.area

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.BaseFragment
import com.example.rising_test_yanolja.databinding.FragmentAreaBinding
import com.example.rising_test_yanolja.src.login.simple.SimpleLoginFragment
import com.example.rising_test_yanolja.src.main.area.map.AreaMapFragment
import com.example.rising_test_yanolja.src.main.area.station.AreaStationFragment
import com.example.rising_test_yanolja.src.main.area.zonning.AreaZonningFragment
import com.google.android.material.tabs.TabLayout

class AreaFragment : BaseFragment<FragmentAreaBinding>(FragmentAreaBinding::bind, R.layout.fragment_area){

    private var fmZooning : AreaZonningFragment ?= null
    private var fmStation : AreaStationFragment?= null
    private var fmMap : AreaMapFragment?= null
    private lateinit var myContext : FragmentActivity



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //처음 화면은 무조건 지역별 fragment가 되도록 셋팅
        fmZooning = AreaZonningFragment()

        childFragmentManager.beginTransaction().add(R.id.main_area_frameLayout,fmZooning!!).commitAllowingStateLoss()

        //abLayout에 구분선 넣는 코드
        var linearLayout = binding.mainAreaTabLayout.getChildAt(0) as LinearLayout
        linearLayout.showDividers = LinearLayout.SHOW_DIVIDER_MIDDLE
        var drawable = getDrawable(requireContext(),R.drawable.tab_divider)
        linearLayout.dividerDrawable = drawable


        //tabLayout 클릭 리스너
        binding.mainAreaTabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab!!.position){
                    0->{
                        childFragmentManager.beginTransaction().show(fmZooning!!).commitAllowingStateLoss()
                        if(fmStation!=null)
                            childFragmentManager.beginTransaction().hide(fmStation!!).commitAllowingStateLoss()
                        if(fmMap!=null)
                            childFragmentManager.beginTransaction().hide(fmMap!!).commitAllowingStateLoss()
                    }
                    1->{
                        if(fmStation==null) {
                            fmStation = AreaStationFragment()
                            childFragmentManager.beginTransaction().add(R.id.main_area_frameLayout, fmStation!!).commitAllowingStateLoss()
                            childFragmentManager.beginTransaction().hide(fmZooning!!).commitAllowingStateLoss()
                            if(fmMap!=null)
                                childFragmentManager.beginTransaction().hide(fmMap!!).commitAllowingStateLoss()
                        } else{
                            childFragmentManager.beginTransaction().hide(fmZooning!!).commitAllowingStateLoss()
                            childFragmentManager.beginTransaction().show(fmStation!!).commitAllowingStateLoss()
                            childFragmentManager.beginTransaction().hide(fmMap!!).commitAllowingStateLoss()
                        }
                    }
                    2->{
                        if(fmMap==null) {
                            fmMap = AreaMapFragment()
                            childFragmentManager.beginTransaction().add(R.id.main_area_frameLayout, fmMap!!).commitAllowingStateLoss()
                            childFragmentManager.beginTransaction().hide(fmZooning!!).commitAllowingStateLoss()
                            if(fmStation!=null)
                                childFragmentManager.beginTransaction().hide(fmStation!!).commitAllowingStateLoss()
                        } else{
                            childFragmentManager.beginTransaction().hide(fmZooning!!).commitAllowingStateLoss()
                            childFragmentManager.beginTransaction().hide(fmStation!!).commitAllowingStateLoss()
                            childFragmentManager.beginTransaction().show(fmMap!!).commitAllowingStateLoss()
                        }
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })


    }
}