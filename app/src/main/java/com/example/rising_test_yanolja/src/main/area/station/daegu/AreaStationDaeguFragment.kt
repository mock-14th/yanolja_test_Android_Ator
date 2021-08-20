package com.example.rising_test_yanolja.src.main.area.station.daegu

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.BaseFragment
import com.example.rising_test_yanolja.databinding.FragmentAreaStationDaeguBinding
import com.example.rising_test_yanolja.src.main.area.zonning.AreaZonningRightRcAdapter

class AreaStationDaeguFragment : BaseFragment<FragmentAreaStationDaeguBinding>(FragmentAreaStationDaeguBinding::bind,
    R.layout.fragment_area_station_daegu){

    private var daeguLineNo1List = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        daeguLineNo1List.add("설화명곡역")
        daeguLineNo1List.add("화원")
        daeguLineNo1List.add("대곡")
        daeguLineNo1List.add("진천")
        daeguLineNo1List.add("월배")
        daeguLineNo1List.add("상인")
        daeguLineNo1List.add("월촌")
        daeguLineNo1List.add("송현")
        daeguLineNo1List.add("성당못")
        daeguLineNo1List.add("대명")
        daeguLineNo1List.add("안지랑")
        daeguLineNo1List.add("현충로")
        daeguLineNo1List.add("영대병원")
        daeguLineNo1List.add("교대")
        daeguLineNo1List.add("명덕")
        daeguLineNo1List.add("반월당")
        daeguLineNo1List.add("중앙로")

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //우측 리사이클러뷰에 어댑터 장착
        binding.mainAreaDaeguRightRecyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.mainAreaDaeguRightRecyclerView.adapter= AreaZonningRightRcAdapter(daeguLineNo1List)


    }
}