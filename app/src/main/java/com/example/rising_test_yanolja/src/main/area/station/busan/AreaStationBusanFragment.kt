package com.example.rising_test_yanolja.src.main.area.station.busan

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.BaseFragment
import com.example.rising_test_yanolja.databinding.FragmentAreaStationBusanBinding
import com.example.rising_test_yanolja.src.main.area.zonning.AreaZonningRightRcAdapter

class AreaStationBusanFragment : BaseFragment<FragmentAreaStationBusanBinding>(
    FragmentAreaStationBusanBinding::bind,
    R.layout.fragment_area_station_busan
) {

    private var busanLineNo1List = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        busanLineNo1List.add("노포")
        busanLineNo1List.add("범어사")
        busanLineNo1List.add("남산")
        busanLineNo1List.add("두실")
        busanLineNo1List.add("구서")
        busanLineNo1List.add("장전")
        busanLineNo1List.add("부산대")
        busanLineNo1List.add("온천장")
        busanLineNo1List.add("명륜")
        busanLineNo1List.add("동래")
        busanLineNo1List.add("교대")
        busanLineNo1List.add("연산")
        busanLineNo1List.add("시청")
        busanLineNo1List.add("양정")
        busanLineNo1List.add("부전")
        busanLineNo1List.add("서면")

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        //우측 리사이클러뷰에 어댑터 장착
        binding.mainAreaBusanRightRecyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.mainAreaBusanRightRecyclerView.adapter= AreaZonningRightRcAdapter(busanLineNo1List)




    }
}
