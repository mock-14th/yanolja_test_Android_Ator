package com.example.rising_test_yanolja.src.main.area.station.capital

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.BaseFragment
import com.example.rising_test_yanolja.databinding.FragmentAreaStationCapitalBinding
import com.example.rising_test_yanolja.src.main.area.zonning.AreaZonningRightRcAdapter

class AreaStationCapitalFragment : BaseFragment<FragmentAreaStationCapitalBinding>(FragmentAreaStationCapitalBinding::bind, R.layout.fragment_area_station_capital) {
    private var capitalLineNo1List = ArrayList<String>()
    private var capitalLineNo2List = ArrayList<String>()
    private var capitalLineNo3List = ArrayList<String>()

    lateinit var btnLeftList: List<ConstraintLayout>
    lateinit var txLeftList: List<TextView>
    lateinit var colorLeftList : List<View>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //1호선 리스트
        capitalLineNo1List.add("소요산")
        capitalLineNo1List.add("동두천")
        capitalLineNo1List.add("보산")
        capitalLineNo1List.add("동두천중앙")
        capitalLineNo1List.add("지행")
        capitalLineNo1List.add("덕정")
        capitalLineNo1List.add("덕계")
        capitalLineNo1List.add("양주")
        capitalLineNo1List.add("녹양")
        capitalLineNo1List.add("가능")
        capitalLineNo1List.add("의정부")
        capitalLineNo1List.add("회룡")
        capitalLineNo1List.add("망월사")
        capitalLineNo1List.add("도봉산")
        capitalLineNo1List.add("도봉")
        capitalLineNo1List.add("방학")
        capitalLineNo1List.add("창동")
        capitalLineNo1List.add("녹천")
        capitalLineNo1List.add("월계")
        capitalLineNo1List.add("광운대")
        capitalLineNo1List.add("석계")
        capitalLineNo1List.add("신이문")
        capitalLineNo1List.add("외대앞")
        capitalLineNo1List.add("회기")
        capitalLineNo1List.add("청량리")
        capitalLineNo1List.add("제기동")
        capitalLineNo1List.add("신설동")
        capitalLineNo1List.add("동묘앞")
        capitalLineNo1List.add("동대문")
        capitalLineNo1List.add("종로5가")
        capitalLineNo1List.add("종로3가")
        capitalLineNo1List.add("종각")
        capitalLineNo1List.add("시청")
        capitalLineNo1List.add("서울")
        capitalLineNo1List.add("남영")
        capitalLineNo1List.add("용산")
        capitalLineNo1List.add("노량진")
        capitalLineNo1List.add("대방")
        capitalLineNo1List.add("신길")
        capitalLineNo1List.add("영등포")
        capitalLineNo1List.add("신도림")
        capitalLineNo1List.add("구로")
        capitalLineNo1List.add("구일")
        capitalLineNo1List.add("개봉")
        capitalLineNo1List.add("오류동")
        capitalLineNo1List.add("온수")
        capitalLineNo1List.add("역곡")
        capitalLineNo1List.add("소사")
        capitalLineNo1List.add("부천")
        capitalLineNo1List.add("중동")
        capitalLineNo1List.add("송내")
        capitalLineNo1List.add("부개")
        capitalLineNo1List.add("부평")
        capitalLineNo1List.add("백운")
        capitalLineNo1List.add("동암")
        capitalLineNo1List.add("간석")
        capitalLineNo1List.add("주안")
        capitalLineNo1List.add("도화")
        capitalLineNo1List.add("제물포")
        capitalLineNo1List.add("도원")
        capitalLineNo1List.add("동인천")
        capitalLineNo1List.add("인천")
        capitalLineNo1List.add("가산디지털단지")
        capitalLineNo1List.add("독산")
        capitalLineNo1List.add("금천구청")
        capitalLineNo1List.add("광명")
        capitalLineNo1List.add("석수")
        capitalLineNo1List.add("관악")
        capitalLineNo1List.add("안양")
        capitalLineNo1List.add("명학")
        capitalLineNo1List.add("금정")
        capitalLineNo1List.add("군포")
        capitalLineNo1List.add("당정")
        capitalLineNo1List.add("의왕")
        capitalLineNo1List.add("성균관대")
        capitalLineNo1List.add("화서")
        capitalLineNo1List.add("수원")
        capitalLineNo1List.add("세류")
        capitalLineNo1List.add("병점")
        capitalLineNo1List.add("서동탄")
        capitalLineNo1List.add("세맘")
        capitalLineNo1List.add("오산대")
        capitalLineNo1List.add("오산")
        capitalLineNo1List.add("진위")
        capitalLineNo1List.add("송탄")
        capitalLineNo1List.add("서정리")
        capitalLineNo1List.add("지제")
        capitalLineNo1List.add("평택")
        capitalLineNo1List.add("성환")
        capitalLineNo1List.add("직산")
        capitalLineNo1List.add("두정")
        capitalLineNo1List.add("천안")
        capitalLineNo1List.add("봉명")
        capitalLineNo1List.add("쌍용(나사렛대)")
        capitalLineNo1List.add("아산")
        capitalLineNo1List.add("배방")
        capitalLineNo1List.add("온양온천")
        capitalLineNo1List.add("신창(순천향대)")



        //2호선 리스트
        capitalLineNo2List.add("시청")
        capitalLineNo2List.add("충정로")
        capitalLineNo2List.add("아현")
        capitalLineNo2List.add("이대")
        capitalLineNo2List.add("신촌")
        capitalLineNo2List.add("홍대입구")
        capitalLineNo2List.add("합정")
        capitalLineNo2List.add("당산")
        capitalLineNo2List.add("영등포구청")
        capitalLineNo2List.add("문래")
        capitalLineNo2List.add("신도림")
        capitalLineNo2List.add("대림")
        capitalLineNo2List.add("구로디지털단지")
        capitalLineNo2List.add("신대방")
        capitalLineNo2List.add("신림")
        capitalLineNo2List.add("봉천")
        capitalLineNo2List.add("서울대입구")
        capitalLineNo2List.add("낙성대")
        capitalLineNo2List.add("사당")
        capitalLineNo2List.add("방배")
        capitalLineNo2List.add("서초")
        capitalLineNo2List.add("교대")
        capitalLineNo2List.add("강남")
        capitalLineNo2List.add("역삼")
        capitalLineNo2List.add("선릉")
        capitalLineNo2List.add("삼성")
        capitalLineNo2List.add("종합운동장")
        capitalLineNo2List.add("잠실새내")
        capitalLineNo2List.add("잠실")
        capitalLineNo2List.add("잠실나루")
        capitalLineNo2List.add("강변")
        capitalLineNo2List.add("구의")
        capitalLineNo2List.add("건대입구")
        capitalLineNo2List.add("성수")
        capitalLineNo2List.add("뚝섬")
        capitalLineNo2List.add("한양대")
        capitalLineNo2List.add("왕십리")
        capitalLineNo2List.add("상왕십리")
        capitalLineNo2List.add("신당")
        capitalLineNo2List.add("동대문역사문화공원")
        capitalLineNo2List.add("을지로4가")
        capitalLineNo2List.add("을지로3가")
        capitalLineNo2List.add("을지로입구")
        capitalLineNo2List.add("도림천")
        capitalLineNo2List.add("양천구청")
        capitalLineNo2List.add("신정네거리")
        capitalLineNo2List.add("까치산")
        capitalLineNo2List.add("용답")
        capitalLineNo2List.add("신답")
        capitalLineNo2List.add("용두")
        capitalLineNo2List.add("신설동")

        //3호선 리스트
        capitalLineNo3List.add("대화")
        capitalLineNo3List.add("주엽")
        capitalLineNo3List.add("정발산")
        capitalLineNo3List.add("마두")
        capitalLineNo3List.add("백석")
        capitalLineNo3List.add("대곡")
        capitalLineNo3List.add("화정")
        capitalLineNo3List.add("원당")
        capitalLineNo3List.add("원흥")
        capitalLineNo3List.add("삼송")
        capitalLineNo3List.add("지축")
        capitalLineNo3List.add("구파발")
        capitalLineNo3List.add("연신내")
        capitalLineNo3List.add("불광")
        capitalLineNo3List.add("녹번")
        capitalLineNo3List.add("홍제")
        capitalLineNo3List.add("무악재")
        capitalLineNo3List.add("독립문")
        capitalLineNo3List.add("경복궁")
        capitalLineNo3List.add("안국")
        capitalLineNo3List.add("종로3가")
        capitalLineNo3List.add("을지로3가")
        capitalLineNo3List.add("충무로")
        capitalLineNo3List.add("동대입구")
        capitalLineNo3List.add("약수")
        capitalLineNo3List.add("금호")
        capitalLineNo3List.add("옥수")
        capitalLineNo3List.add("압구정")
        capitalLineNo3List.add("신사")
        capitalLineNo3List.add("잠원")
        capitalLineNo3List.add("교대")
        capitalLineNo3List.add("고속터미널")
        capitalLineNo3List.add("남부터미널")
        capitalLineNo3List.add("양재")
        capitalLineNo3List.add("매봉")
        capitalLineNo3List.add("도곡")
        capitalLineNo3List.add("대치")
        capitalLineNo3List.add("학여울")
        capitalLineNo3List.add("대청")
        capitalLineNo3List.add("일원")
        capitalLineNo3List.add("수서")
        capitalLineNo3List.add("가락시장")
        capitalLineNo3List.add("경찰병원")
        capitalLineNo3List.add("오금")
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLeftList= arrayListOf(
            binding.mainAreaBtn0,
            binding.mainAreaBtn1,
            binding.mainAreaBtn2
        )

        txLeftList= arrayListOf(
            binding.mainAreaTx0,
            binding.mainAreaTx1,
            binding.mainAreaTx2
        )

        colorLeftList= arrayListOf(
            binding.lineNo1,
            binding.lineNo2,
            binding.lineNo3
        )


        //버튼들 클릭 리스너 달아 줌줌
        binding.mainAreaBtn0.setOnClickListener(btnClickListener)
        binding.mainAreaBtn1.setOnClickListener(btnClickListener)
        binding.mainAreaBtn2.setOnClickListener(btnClickListener)




        //우측 리사이클러뷰에 어댑터 장착
        binding.mainAreaCapitalRightRecyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.mainAreaCapitalRightRecyclerView.adapter=AreaZonningRightRcAdapter(capitalLineNo1List)



    }


    //좌측 메뉴의 버튼을 누르면 라디오 버튼처럼 작동하기 위해 모든 버튼의 background를  solid_false로 변경하는 함수
    fun allPressedFalse() {
        for (i in 0..2) {
            btnLeftList[i].setBackgroundResource(R.drawable.solid_false)
            txLeftList[i].setTextColor(ContextCompat.getColor(requireContext(),R.color.tabTextGray))
            colorLeftList[i].visibility = View.INVISIBLE
        }
    }


    val btnClickListener: View.OnClickListener = object : View.OnClickListener {
        override fun onClick(v: View?) {
            allPressedFalse()
            when (v) {
                binding.mainAreaBtn0 -> {
                    binding.mainAreaBtn0.setBackgroundResource(R.drawable.solid_true)
                    binding.mainAreaTx0.setTextColor(ContextCompat.getColor(context!!,R.color.black))
                    binding.lineNo1.visibility=View.VISIBLE
                    binding.mainAreaCapitalRightRecyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    binding.mainAreaCapitalRightRecyclerView.adapter=AreaZonningRightRcAdapter(capitalLineNo1List)
                }
                binding.mainAreaBtn1 -> {
                    binding.mainAreaBtn1.setBackgroundResource(R.drawable.solid_true)
                    binding.mainAreaTx1.setTextColor(ContextCompat.getColor(context!!,R.color.black))
                    binding.lineNo2.visibility=View.VISIBLE
                    binding.mainAreaCapitalRightRecyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    binding.mainAreaCapitalRightRecyclerView.adapter=AreaZonningRightRcAdapter(capitalLineNo2List)
                }
                binding.mainAreaBtn2 -> {
                    binding.mainAreaBtn2.setBackgroundResource(R.drawable.solid_true)
                    binding.mainAreaTx2.setTextColor(ContextCompat.getColor(context!!,R.color.black))
                    binding.lineNo3.visibility=View.VISIBLE
                    binding.mainAreaCapitalRightRecyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    binding.mainAreaCapitalRightRecyclerView.adapter=AreaZonningRightRcAdapter(capitalLineNo3List)
                }

            }
        }
    }
}