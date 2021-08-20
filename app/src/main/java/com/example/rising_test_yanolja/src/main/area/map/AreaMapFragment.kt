package com.example.rising_test_yanolja.src.main.area.map

import android.os.Bundle
import android.view.View
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.ApplicationClass
import com.example.rising_test_yanolja.config.BaseFragment
import com.example.rising_test_yanolja.databinding.FragmentAreaMapBinding
import com.naver.maps.map.NaverMap
import com.naver.maps.map.NaverMapSdk
import com.naver.maps.map.OnMapReadyCallback

class AreaMapFragment : BaseFragment<FragmentAreaMapBinding>(FragmentAreaMapBinding::bind, R.layout.fragment_area_map) , OnMapReadyCallback {

    private lateinit var mNaverMap: NaverMap


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        NaverMapSdk.getInstance(requireContext()).client = NaverMapSdk.NaverCloudPlatformClient(ApplicationClass.NAVER_MAP_API.CLINET_ID)

    }


    override fun onMapReady(naverMap: NaverMap) {

    }


}