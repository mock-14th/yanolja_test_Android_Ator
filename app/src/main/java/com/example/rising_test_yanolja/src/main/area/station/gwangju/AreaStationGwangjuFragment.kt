package com.example.rising_test_yanolja.src.main.area.station.gwangju

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.BaseFragment
import com.example.rising_test_yanolja.databinding.FragmentAreaStationGwangjuBinding
import com.example.rising_test_yanolja.src.main.area.zonning.AreaZonningRightRcAdapter

class AreaStationGwangjuFragment : BaseFragment<FragmentAreaStationGwangjuBinding>(
    FragmentAreaStationGwangjuBinding::bind, R.layout.fragment_area_station_gwangju){

    private var gwangjuLineNo1List = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gwangjuLineNo1List.add("평동")
        gwangjuLineNo1List.add("도산")
        gwangjuLineNo1List.add("광주송정")
        gwangjuLineNo1List.add("송정공원")
        gwangjuLineNo1List.add("공항")
        gwangjuLineNo1List.add("김대중컨벤션센터")
        gwangjuLineNo1List.add("상무")
        gwangjuLineNo1List.add("운천")
        gwangjuLineNo1List.add("쌍촌")
        gwangjuLineNo1List.add("화정")
        gwangjuLineNo1List.add("농성")
        gwangjuLineNo1List.add("돌고개")
        gwangjuLineNo1List.add("양동시장")
        gwangjuLineNo1List.add("금남로5가")
        gwangjuLineNo1List.add("금남로4가")
        gwangjuLineNo1List.add("문화전당")
        gwangjuLineNo1List.add("남광주")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //우측 리사이클러뷰에 어댑터 장착
        binding.mainAreaGwangjuRightRecyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.mainAreaGwangjuRightRecyclerView.adapter= AreaZonningRightRcAdapter(gwangjuLineNo1List)

    }
}