package com.example.rising_test_yanolja.src.main.area.station.daejeon

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.BaseFragment
import com.example.rising_test_yanolja.databinding.FragmentAreaStationDaejeonBinding
import com.example.rising_test_yanolja.src.main.area.zonning.AreaZonningRightRcAdapter

class AreaStationDaejeonFragment: BaseFragment<FragmentAreaStationDaejeonBinding>(FragmentAreaStationDaejeonBinding::bind, R.layout.fragment_area_station_daejeon){


    private var daejeonLineNo1List = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        daejeonLineNo1List.add("반석")
        daejeonLineNo1List.add("지족")
        daejeonLineNo1List.add("노은")
        daejeonLineNo1List.add("월드컵경기장")
        daejeonLineNo1List.add("현충원")
        daejeonLineNo1List.add("구암")
        daejeonLineNo1List.add("유성온천")
        daejeonLineNo1List.add("갑천")
        daejeonLineNo1List.add("월평")
        daejeonLineNo1List.add("갈마")
        daejeonLineNo1List.add("정부청사")
        daejeonLineNo1List.add("시청")
        daejeonLineNo1List.add("탄방")
        daejeonLineNo1List.add("용문")
        daejeonLineNo1List.add("오룡")
        daejeonLineNo1List.add("서대전네거리")
        daejeonLineNo1List.add("중구청")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //우측 리사이클러뷰에 어댑터 장착
        binding.mainAreaDaejeonRightRecyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.mainAreaDaejeonRightRecyclerView.adapter= AreaZonningRightRcAdapter(daejeonLineNo1List)

    }
}