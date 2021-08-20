package com.example.rising_test_yanolja.src.main.area.zonning

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.BaseFragment
import com.example.rising_test_yanolja.databinding.FragmentAreaZonningBinding
import org.w3c.dom.Text

class AreaZonningFragment : BaseFragment<FragmentAreaZonningBinding>(FragmentAreaZonningBinding::bind, R.layout.fragment_area_zonning){
    private var areaSeouldList = ArrayList<String>()
    private val areaGyeonggiList = ArrayList<String>()
    private val areaIncheoniList = ArrayList<String>()
    private val areaGanawonList = ArrayList<String>()
    private val areaJejuList = ArrayList<String>()
    private val areaDaejunList = ArrayList<String>()
    private val areaChungbukList = ArrayList<String>()
    private val areaChungnamList = ArrayList<String>()
    private val areaBusanList = ArrayList<String>()
    private val areaUlsanList = ArrayList<String>()
    private val areaGyeongnamList = ArrayList<String>()
    private val areaDaeguList = ArrayList<String>()
    private val areaGyeongbokList = ArrayList<String>()
    private val areaGwangjuList = ArrayList<String>()
    private val areaJeonnamList = ArrayList<String>()
    private val areaJeonnjuList = ArrayList<String>()


    lateinit var btnLeftList: List<LinearLayout>
    lateinit var txLeftList: List<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //서울 리스트
        areaSeouldList.add("강남/역삼/삼성/논현")
        areaSeouldList.add("서초/신사/방배")
        areaSeouldList.add("잠실/신천(잠실새내)")
        areaSeouldList.add("영등포/여의도")
        areaSeouldList.add("신림/서울대/사당/동작")
        areaSeouldList.add("천호/길동/둔촌")
        areaSeouldList.add("화곡/까치산/양천/목동")
        areaSeouldList.add("구로/금천/오류/신도림")
        areaSeouldList.add("연신내/불광/응암")
        areaSeouldList.add("연신내/불광/응암")
        areaSeouldList.add("종로/대학로/동묘앞역")
        areaSeouldList.add("성신여대/성북/월곡")
        areaSeouldList.add("이태원/용산/서울역/명동/회현")
        areaSeouldList.add("동대문/을지로/충무로/신당/약수")
        areaSeouldList.add("회기/고려대/청량리/신설동")
        areaSeouldList.add("장안동/답십리")
        areaSeouldList.add("건대/군자/구의")
        areaSeouldList.add("왕십리/성수/금호")
        areaSeouldList.add("수유/미아")
        areaSeouldList.add("상봉/중랑/면목")
        areaSeouldList.add("태릉/노원/도봉/창동")


        //경기 리스트
        areaGyeonggiList.add("수원 인계/권선/영통")
        areaGyeonggiList.add("수원역/구운/장안/세류")
        areaGyeonggiList.add("안양/평촌/인덕원/과천")
        areaGyeonggiList.add("성남/분당/위례")
        areaGyeonggiList.add("용인")
        areaGyeonggiList.add("동탄/화성/오산/병점")
        areaGyeonggiList.add("하남/광주/여주/이천")
        areaGyeonggiList.add("안산 중앙역")
        areaGyeonggiList.add("안산 고잔/상록수/선부동/월피동")
        areaGyeonggiList.add("군포/의왕/금정/산본")
        areaGyeonggiList.add("시흥/월곶")
        areaGyeonggiList.add("광명")
        areaGyeonggiList.add("평택/송탄/안성")
        areaGyeonggiList.add("부천")
        areaGyeonggiList.add("일산/고양")
        areaGyeonggiList.add("파주")
        areaGyeonggiList.add("김포")
        areaGyeonggiList.add("의정부")
        areaGyeonggiList.add("구리")
        areaGyeonggiList.add("남양주(다산/별내/와부/호평)")
        areaGyeonggiList.add("남양주(오남/조안/화도/진접)")
        areaGyeonggiList.add("포천")
        areaGyeonggiList.add("양주/동두천/연천")
        areaGyeonggiList.add("가평/청평")
        areaGyeonggiList.add("제부도/대부도")


        //인천 리스트
        areaIncheoniList.add("부평")
        areaIncheoniList.add("구월")
        areaIncheoniList.add("서구(석남,서구청,검단)")
        areaIncheoniList.add("계양(작전,경인교대)")
        areaIncheoniList.add("주안")
        areaIncheoniList.add("송도/연수")
        areaIncheoniList.add("인천공항/을왕리/영종도")
        areaIncheoniList.add("중구(월미도/신포/동인천/연안부두)")
        areaIncheoniList.add("강화/옹진")
        areaIncheoniList.add("동암/간석")
        areaIncheoniList.add("남동구(소래포구/호구포")
        areaIncheoniList.add("용현/숭의/도화/동구")



        //강원 리스트
        areaGanawonList.add("춘천/강촌")
        areaGanawonList.add("원주")
        areaGanawonList.add("경포대/사천/주문진/정동진")
        areaGanawonList.add("강릉역/교동/옥계")
        areaGanawonList.add("영월/정선")
        areaGanawonList.add("속초/고성")
        areaGanawonList.add("양양(서피비치/낙산)")
        areaGanawonList.add("동해/삼척/태백")
        areaGanawonList.add("태백")
        areaGanawonList.add("홍천/횡성")
        areaGanawonList.add("화천/철원/인제/양구")


        //제주 리스트
        areaJejuList.add("제주시/제주공항")
        areaJejuList.add("서귀포시")
        areaJejuList.add("하귀/애월/한림/협재")

        //대전 리스트
        areaDaejunList.add("유성구")
        areaDaejunList.add("중구(은행/대흥/선화/유천)")
        areaDaejunList.add("동구(용전/복합터미널)")
        areaDaejunList.add("서구(둔산/용문/월평)")
        areaDaejunList.add("대덕구(중리/신탄진)")

        //충북 리스트
        areaChungbukList.add("청주 흥덕구 / 서원구 (청주 터미널)")
        areaChungbukList.add("청주 상당구 / 창원구 (청주국제공항)")
        areaChungbukList.add("충주/수안보")
        areaChungbukList.add("제천/단양")
        areaChungbukList.add("진천/음성")
        areaChungbukList.add("보은/옥천/괴산/증평/영동")

        //충남 리스트
        areaChungnamList.add("천안 서북구")
        areaChungnamList.add("천안 동남구")
        areaChungnamList.add("아산")
        areaChungnamList.add("공주/동학사/세종")
        areaChungnamList.add("계룡/금산/논산/청양")
        areaChungnamList.add("예산/홍성")
        areaChungnamList.add("태안/안면도/서산")
        areaChungnamList.add("당진")
        areaChungnamList.add("보령/대천해수욕장")
        areaChungnamList.add("서천/부여")

        //부산 리스트
        areaBusanList.add("해운대/센텀시티/재송")
        areaBusanList.add("송정/기장/정관")
        areaBusanList.add("광안리/수영")
        areaBusanList.add("경성대/대연/용호동/문현")
        areaBusanList.add("서면/양정/초읍/부산시민공원")
        areaBusanList.add("남포동/중앙동/태종대/송도/영도")
        areaBusanList.add("부산역/범일동/부산진역")
        areaBusanList.add("연산/토곡")
        areaBusanList.add("동래/사직/온천장/부산대/구서/서동")
        areaBusanList.add("사상(경전철)/엄궁/학장")
        areaBusanList.add("덕전/화명/만덕/구포")
        areaBusanList.add("하단/명지/김해공항/다대포/")


        //울산 리스트
        areaUlsanList.add("남구/중구(삼산/성남/무거/신정)")
        areaUlsanList.add("동구/북구/울주군(일산/진장)")


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //왼쪽 메뉴 클릭 효과 주기 위한 LinearLayout 리스트
        txLeftList = arrayListOf(
            binding.mainAreaTx0,
            binding.mainAreaTx1,
            binding.mainAreaTx2,
            binding.mainAreaTx3,
            binding.mainAreaTx4,
            binding.mainAreaTx5,
            binding.mainAreaTx6,
            binding.mainAreaTx7,
            binding.mainAreaTx8,
            binding.mainAreaTx9,
            binding.mainAreaTx10,
            binding.mainAreaTx11,
            binding.mainAreaTx12,
            binding.mainAreaTx13,
            binding.mainAreaTx14,
            binding.mainAreaTx15)


        //왼쪽 버튼의 TextView 리스트
        btnLeftList = arrayListOf(
            binding.mainAreaBtn0,
            binding.mainAreaBtn1,
            binding.mainAreaBtn2,
            binding.mainAreaBtn3,
            binding.mainAreaBtn4,
            binding.mainAreaBtn5,
            binding.mainAreaBtn6,
            binding.mainAreaBtn7,
            binding.mainAreaBtn8,
            binding.mainAreaBtn9,
            binding.mainAreaBtn10,
            binding.mainAreaBtn11,
            binding.mainAreaBtn12,
            binding.mainAreaBtn13,
            binding.mainAreaBtn14,
            binding.mainAreaBtn15)

        //왼쪽 메뉴 버튼들 클릭 리스너 달아줌
        binding.mainAreaBtn0.setOnClickListener(btnClickListener)
        binding.mainAreaBtn1.setOnClickListener(btnClickListener)
        binding.mainAreaBtn2.setOnClickListener(btnClickListener)
        binding.mainAreaBtn3.setOnClickListener(btnClickListener)
        binding.mainAreaBtn4.setOnClickListener(btnClickListener)
        binding.mainAreaBtn5.setOnClickListener(btnClickListener)
        binding.mainAreaBtn6.setOnClickListener(btnClickListener)
        binding.mainAreaBtn7.setOnClickListener(btnClickListener)
        binding.mainAreaBtn8.setOnClickListener(btnClickListener)
        binding.mainAreaBtn9.setOnClickListener(btnClickListener)
        binding.mainAreaBtn10.setOnClickListener(btnClickListener)
        binding.mainAreaBtn11.setOnClickListener(btnClickListener)
        binding.mainAreaBtn12.setOnClickListener(btnClickListener)
        binding.mainAreaBtn13.setOnClickListener(btnClickListener)
        binding.mainAreaBtn14.setOnClickListener(btnClickListener)
        binding.mainAreaBtn15.setOnClickListener(btnClickListener)


        //right 리사이클러뷰 어댑터 장착
        binding.mainAreaRightRecyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.mainAreaRightRecyclerView.adapter=AreaZonningRightRcAdapter(areaSeouldList)

    }





    //좌측 메뉴의 버튼을 누르면 라디오 버튼처럼 작동하기 위해 모든 버튼의 background를  solid_false로 변경하는 함수
    fun allPressedFalse() {
        for (i in 0..15) {
            btnLeftList[i].setBackgroundResource(R.drawable.solid_false)
            txLeftList[i].setTextColor(ContextCompat.getColor(requireContext(),R.color.tabTextGray))
        }
    }




    //좌측 메뉴 버튼 클릭 리스너
    val btnClickListener: View.OnClickListener = object : View.OnClickListener {
        override fun onClick(v: View?) {
            allPressedFalse()
            when (v) {
                binding.mainAreaBtn0 -> {
                    binding.mainAreaBtn0.setBackgroundResource(R.drawable.solid_true)
                    binding.mainAreaTx0.setTextColor(ContextCompat.getColor(context!!,R.color.black))
                    binding.mainAreaRightRecyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    binding.mainAreaRightRecyclerView.adapter=AreaZonningRightRcAdapter(areaSeouldList)
                }
                binding.mainAreaBtn1 ->{
                    binding.mainAreaBtn1.setBackgroundResource(R.drawable.solid_true)
                    binding.mainAreaTx1.setTextColor(ContextCompat.getColor(context!!,R.color.black))
                    binding.mainAreaRightRecyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    binding.mainAreaRightRecyclerView.adapter=AreaZonningRightRcAdapter(areaGyeonggiList)
                }
                binding.mainAreaBtn2 ->{
                    binding.mainAreaBtn2.setBackgroundResource(R.drawable.solid_true)
                    binding.mainAreaTx2.setTextColor(ContextCompat.getColor(context!!,R.color.black))
                    binding.mainAreaRightRecyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    binding.mainAreaRightRecyclerView.adapter=AreaZonningRightRcAdapter(areaIncheoniList)
                }
                binding.mainAreaBtn3 ->{
                    binding.mainAreaBtn3.setBackgroundResource(R.drawable.solid_true)
                    binding.mainAreaTx3.setTextColor(ContextCompat.getColor(context!!,R.color.black))
                    binding.mainAreaRightRecyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    binding.mainAreaRightRecyclerView.adapter=AreaZonningRightRcAdapter(areaGanawonList)
                }
                binding.mainAreaBtn4 ->{
                    binding.mainAreaBtn4.setBackgroundResource(R.drawable.solid_true)
                    binding.mainAreaTx4.setTextColor(ContextCompat.getColor(context!!,R.color.black))
                    binding.mainAreaRightRecyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    binding.mainAreaRightRecyclerView.adapter=AreaZonningRightRcAdapter(areaJejuList)
                }
                binding.mainAreaBtn5 ->{
                    binding.mainAreaBtn5.setBackgroundResource(R.drawable.solid_true)
                    binding.mainAreaTx5.setTextColor(ContextCompat.getColor(context!!,R.color.black))
                    binding.mainAreaRightRecyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    binding.mainAreaRightRecyclerView.adapter=AreaZonningRightRcAdapter(areaDaejunList)
                }
                binding.mainAreaBtn6 ->{
                    binding.mainAreaBtn6.setBackgroundResource(R.drawable.solid_true)
                    binding.mainAreaTx6.setTextColor(ContextCompat.getColor(context!!,R.color.black))
                    binding.mainAreaRightRecyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    binding.mainAreaRightRecyclerView.adapter=AreaZonningRightRcAdapter(areaChungbukList)
                }
                binding.mainAreaBtn7 ->{
                    binding.mainAreaBtn7.setBackgroundResource(R.drawable.solid_true)
                    binding.mainAreaTx7.setTextColor(ContextCompat.getColor(context!!,R.color.black))
                    binding.mainAreaRightRecyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    binding.mainAreaRightRecyclerView.adapter=AreaZonningRightRcAdapter(areaChungnamList)
                }
                binding.mainAreaBtn8 ->{
                    binding.mainAreaBtn8.setBackgroundResource(R.drawable.solid_true)
                    binding.mainAreaTx8.setTextColor(ContextCompat.getColor(context!!,R.color.black))
                    binding.mainAreaRightRecyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    binding.mainAreaRightRecyclerView.adapter=AreaZonningRightRcAdapter(areaBusanList)
                }
                binding.mainAreaBtn9 ->{
                    binding.mainAreaBtn9.setBackgroundResource(R.drawable.solid_true)
                    binding.mainAreaTx9.setTextColor(ContextCompat.getColor(context!!,R.color.black))
                    binding.mainAreaRightRecyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    binding.mainAreaRightRecyclerView.adapter=AreaZonningRightRcAdapter(areaUlsanList)
                }
                binding.mainAreaBtn10 ->{
                    binding.mainAreaBtn10.setBackgroundResource(R.drawable.solid_true)
                    binding.mainAreaTx10.setTextColor(ContextCompat.getColor(context!!,R.color.black))
                    binding.mainAreaRightRecyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    binding.mainAreaRightRecyclerView.adapter=AreaZonningRightRcAdapter(areaChungbukList)
                }
                binding.mainAreaBtn11 ->{
                    binding.mainAreaBtn11.setBackgroundResource(R.drawable.solid_true)
                    binding.mainAreaTx11.setTextColor(ContextCompat.getColor(context!!,R.color.black))
                    binding.mainAreaRightRecyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    binding.mainAreaRightRecyclerView.adapter=AreaZonningRightRcAdapter(areaGanawonList)
                }
                binding.mainAreaBtn12 ->{
                    binding.mainAreaBtn12.setBackgroundResource(R.drawable.solid_true)
                    binding.mainAreaTx12.setTextColor(ContextCompat.getColor(context!!,R.color.black))
                    binding.mainAreaRightRecyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    binding.mainAreaRightRecyclerView.adapter=AreaZonningRightRcAdapter(areaJejuList)
                }
                binding.mainAreaBtn13 ->{
                    binding.mainAreaBtn13.setBackgroundResource(R.drawable.solid_true)
                    binding.mainAreaTx13.setTextColor(ContextCompat.getColor(context!!,R.color.black))
                    binding.mainAreaRightRecyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    binding.mainAreaRightRecyclerView.adapter=AreaZonningRightRcAdapter(areaSeouldList)
                }
                binding.mainAreaBtn14 ->{
                    binding.mainAreaBtn14.setBackgroundResource(R.drawable.solid_true)
                    binding.mainAreaTx14.setTextColor(ContextCompat.getColor(context!!,R.color.black))
                    binding.mainAreaRightRecyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    binding.mainAreaRightRecyclerView.adapter=AreaZonningRightRcAdapter(areaChungnamList)
                }
                binding.mainAreaBtn15 ->{
                    binding.mainAreaBtn15.setBackgroundResource(R.drawable.solid_true)
                    binding.mainAreaTx15.setTextColor(ContextCompat.getColor(context!!,R.color.black))
                    binding.mainAreaRightRecyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    binding.mainAreaRightRecyclerView.adapter=AreaZonningRightRcAdapter(areaIncheoniList)
                }
            }
        }
    }
}