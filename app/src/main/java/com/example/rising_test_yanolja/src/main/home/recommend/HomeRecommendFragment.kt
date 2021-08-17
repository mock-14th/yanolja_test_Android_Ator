package com.example.rising_test_yanolja.src.main.home.recommend

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.databinding.*
import com.example.rising_test_yanolja.src.main.home.recommend.model.NewHotInfo
import com.example.rising_test_yanolja.src.main.home.recommend.model.NewHotUnderInfo
import com.example.rising_test_yanolja.src.main.home.recommend.model.TodayMagazineInfo
import com.google.android.material.tabs.TabLayoutMediator
import com.softsquared.template.kotlin.config.BaseFragment

class HomeRecommendFragment : BaseFragment<FragmentHomeRecommendBinding>(
    FragmentHomeRecommendBinding::bind,
    R.layout.fragment_home_recommend
) {
    private var newHotList = ArrayList<NewHotInfo>()
    private var newHotUnderList = ArrayList<NewHotUnderInfo>()
    private var adImgList = ArrayList<Int>()
    private var todaySpecialCostList = ArrayList<Int>()
    private var weeklyImgList = ArrayList<Int>()
    private var todayMagazineList = ArrayList<TodayMagazineInfo>()
    lateinit var parentViewPager2 : ViewPager2
    private var myHandler = MyHandler() // 배너를 자동으로 스크롤링 하기 위한 핸들러
    private val intervalTime = 3000.toLong() // 몇초 간격으로 페이지를 넘길것인지 (1500 = 1.5초)
    private var currentPosition = Int.MAX_VALUE / 2


    private var isSellerInfo = false

    //weekly tabLayout title array
    val tabTitleList = arrayListOf("모바일교환권","펜션","호텔","레저/티켓","모텔","게스트하우스")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //NewHot 리사이클러뷰를 위한 임시 리스트
        newHotList.add(NewHotInfo(R.drawable.bus_img, "고속버스", true))
        newHotList.add(NewHotInfo(R.drawable.villa_img, "풀빌라", false))
        newHotList.add(NewHotInfo(R.drawable.pool_img, "물놀이특가", false))
        newHotList.add(NewHotInfo(R.drawable.kids_img, "아이야놀자", false))
        newHotList.add(NewHotInfo(R.drawable.hokangs_img, "호캉스패키지", false))
        newHotList.add(NewHotInfo(R.drawable.restaurant_img, "맛집", true))


        //NewHotUnder 리사이클러뷰를 위한 임시 리스트
        newHotUnderList.add(NewHotUnderInfo(R.drawable.nolteck_img,"돈버는놀테크"))
        newHotUnderList.add(NewHotUnderInfo(R.drawable.coinmachine_img,"코인뽑기머신"))
        newHotUnderList.add(NewHotUnderInfo(R.drawable.mycupon_img,"나만의쿠폰"))
        newHotUnderList.add(NewHotUnderInfo(R.drawable.card_discount_img,"카드할인"))
        newHotUnderList.add(NewHotUnderInfo(R.drawable.month8_event_img,"8월혜택모음"))
        newHotUnderList.add(NewHotUnderInfo(R.drawable.count_coupon,"선착순쿠폰"))
        newHotUnderList.add(NewHotUnderInfo(R.drawable.infinite_coupon_img,"무한쿠폰룸"))
        newHotUnderList.add(NewHotUnderInfo(R.drawable.motel_special_cost_img,"모텔특가"))
        newHotUnderList.add(NewHotUnderInfo(R.drawable.hotel_special_cost_img,"호텔특가"))
        newHotUnderList.add(NewHotUnderInfo(R.drawable.pension_special_cost_img,"펜션특가"))

        //ad viewPager2를 위한 이미지 리스트
        adImgList.add(R.drawable.recommend_ad1_img)
        adImgList.add(R.drawable.recommend_ad2_img)
        adImgList.add(R.drawable.recommend_ad3_img)
        adImgList.add(R.drawable.recommend_ad4_img)
        adImgList.add(R.drawable.recommend_ad5_img)
        adImgList.add(R.drawable.recommend_ad6_img)
        adImgList.add(R.drawable.recommend_ad7_img)
        adImgList.add(R.drawable.recommend_ad8_img)
        adImgList.add(R.drawable.recommend_ad9_img)

        //today_special_cost_rcview를 위한 이미지 리스트
        todaySpecialCostList.add(R.drawable.today_special_cost_img1)
        todaySpecialCostList.add(R.drawable.today_special_cost_img2)
        todaySpecialCostList.add(R.drawable.today_special_cost_img3)


        //weekly viewPager2를 위한 이미지 리스트
        weeklyImgList.add(R.drawable.weekly_mobile_change_cupon_img)
        weeklyImgList.add(R.drawable.weekly_pension_img)
        weeklyImgList.add(R.drawable.weekly_hotel_img)
        weeklyImgList.add(R.drawable.weekly_leisure_img)
        weeklyImgList.add(R.drawable.weekly_motel_img)
        weeklyImgList.add(R.drawable.weekly_guest_house_img)


        //todayMagazine rcview를 위한 TodayMagazineInfo 리스트
        todayMagazineList.add(TodayMagazineInfo(R.drawable.today_magazine_img1,"숙소","숲 속 언택트 힐링 \n홍천 부티크 풀빌라"))
        todayMagazineList.add(TodayMagazineInfo(R.drawable.today_magazine_img2,"숙소","국내 1위로 뽑혔다는 \n강릉 오션뷰 풀빌라"))
        todayMagazineList.add(TodayMagazineInfo(R.drawable.today_magazine_img3,"숙소","1시간이면 갈수 있는\n근교 숲캉스 숙수"))
        todayMagazineList.add(TodayMagazineInfo(R.drawable.today_magazine_img4,"숙소","SNS에서 유명한\n테마별 태안 숙소"))
        todayMagazineList.add(TodayMagazineInfo(R.drawable.today_magazine_img5,"숙소","프라이빗하게 즐기는 \n가평 양평 숙소6"))




        //부모 activity 변수 생성
        parentViewPager2 = requireActivity().findViewById<ViewPager2>(R.id.main_home_viewPager2)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //NewHot 리사이클러뷰 어댑터 장착
        binding.mainHomeRecommendRcViewNewHot.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.mainHomeRecommendRcViewNewHot.adapter = HomeRecommendNewHotRcViewAdapter(newHotList)

        //NewHot 리사이클러뷰가 스크롤 될 때 부모의 viewPager swipe를 막는 코드
        binding.mainHomeRecommendRcViewNewHot.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                when(e.action){
                    MotionEvent.ACTION_DOWN->{
                        parentViewPager2.isUserInputEnabled = false
                    }
                    MotionEvent.ACTION_UP->{
                        parentViewPager2.isUserInputEnabled = true
                    }
                }
                return false
            }

            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
            }

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
            }
        })

        //NewHotUnder 리사이클러뷰 어댑터 장착
        binding.mainHomeRecommendRcViewNewHotUnder.layoutManager =
            GridLayoutManager(context,5)
        binding.mainHomeRecommendRcViewNewHotUnder.adapter =HomeRecommendNewHotUnderRcViewAdapter(newHotUnderList)

        //Ad viewPager 어댑터 장착
        binding.mainHomeRecommendViewPager2Ad.adapter = HomeRecommendAdViewPager2Adapter(adImgList)
        binding.mainHomeRecommendViewPager2Ad.orientation = ViewPager2.ORIENTATION_HORIZONTAL //스크롤 방향을 가로로 지정

        //Ad viewPager가 움직일 때 부모의 viewpager를 막는 코드
        binding.mainHomeRecommendViewPager2Ad.getChildAt(0).setOnTouchListener { v, event ->
            when(event.action){
                MotionEvent.ACTION_DOWN->{
                    parentViewPager2.isUserInputEnabled = false
                }
                MotionEvent.ACTION_UP->{
                    parentViewPager2.isUserInputEnabled = true
                }
            }
            false
        }


        //Ad viewPager 현재배너 출력하는 코드
        if(adImgList.size>9) //1의자리 숫자면 앞에 0을 붙여야 하기 때문에 if문으로 확인해 준다.
            binding.textViewTotalBanner.text = adImgList.size.toString() //리스트 최대 길이 만큼 total banner 텍스트를 변경해준다.
        else
            binding.textViewTotalBanner.text = "0${adImgList.size}" //리스트 최대 길이 만큼 total banner 텍스트를 변경해준다.


        binding.mainHomeRecommendViewPager2Ad.apply {
            registerOnPageChangeCallback(object:ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    currentPosition = position
                    if(position%adImgList.size>8)
                        binding.textViewCurrentBanner.text = "${(position%adImgList.size)+1}"
                    else
                        binding.textViewCurrentBanner.text = "0${(position%adImgList.size)+1}"
                }

                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                    when(state){
                        // 뷰페이저에서 손 떼었을때 / 뷰페이저 멈춰있을 때
                        ViewPager2.SCROLL_STATE_IDLE -> autoScrollStart(intervalTime)
                        // 뷰페이저 움직이는 중
                        ViewPager2.SCROLL_STATE_DRAGGING -> autoScrollStop()
                    }
                }
            })
        }


        //today_special_cost_rcView 어댑터 장착
        binding.mainHomeRecommendRcViewTodaySpecialCost.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.mainHomeRecommendRcViewTodaySpecialCost.adapter = HomeRecommendTodaySpecialCostRcViewAdapter(todaySpecialCostList)

        //today_special_cost_rcView 리사이클러뷰가 스크롤 될 때 부모의 viewPager swipe를 막는 코드
        binding.mainHomeRecommendRcViewTodaySpecialCost.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                when(e.action){
                    MotionEvent.ACTION_DOWN->{
                        parentViewPager2.isUserInputEnabled = false
                    }
                    MotionEvent.ACTION_UP->{
                        parentViewPager2.isUserInputEnabled = true
                    }
                }
                return false
            }

            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
            }

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
            }
        })


        //weekly_top_viewPager2 어댑터 장착
        binding.mainHomeRecommendWeeklyViewPager2.adapter = HomeRecommendWeeklyTopViewPager2Adapter(weeklyImgList)
        binding.mainHomeRecommendWeeklyViewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        TabLayoutMediator(binding.mainHomeRecommendWeeklyTabLayout,binding.mainHomeRecommendWeeklyViewPager2){ tab, position ->
            tab.text = tabTitleList[position]
        }.attach()

        //weekly_top_viewPager2 swipe할 때 부모 뷰페이저 swipe막는 코드
        binding.mainHomeRecommendWeeklyViewPager2.getChildAt(0).setOnTouchListener { v, event ->
            when(event.action){
                MotionEvent.ACTION_DOWN->{
                    parentViewPager2.isUserInputEnabled = false
                }
                MotionEvent.ACTION_UP->{
                    parentViewPager2.isUserInputEnabled = true
                }
            }
            false
        }


        //today_magazine rcview 어댑터 장착
        binding.mainHomeRecommendRcViewTodayMagazine.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.mainHomeRecommendRcViewTodayMagazine.adapter = HomeRecommendTodayMagazineRcViewAdapter(todayMagazineList)

        //today_magazine rcview 부모 swipe 막는 코드
        //today_special_cost_rcView 리사이클러뷰가 스크롤 될 때 부모의 viewPager swipe를 막는 코드
        binding.mainHomeRecommendRcViewTodayMagazine.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                when(e.action){
                    MotionEvent.ACTION_DOWN->{
                        parentViewPager2.isUserInputEnabled = false
                    }
                    MotionEvent.ACTION_UP->{
                        parentViewPager2.isUserInputEnabled = true
                    }
                }
                return false
            }

            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
            }

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
            }
        })




        //약관 사업자 정보 클릭 시 사업자 정보 출력해주는 코드
        binding.mainHomeRecommendPostingBtnSellerInfo.setOnClickListener {
            if(!isSellerInfo){
                isSellerInfo=true
                binding.mainHomeRecommendPostingLinearlayoutSellerInfo.visibility=View.VISIBLE
                binding.mainHomeRecommendPostingBtnImgSellerInfo.setImageResource(R.drawable.up_img)
            }else{
                isSellerInfo=false
                binding.mainHomeRecommendPostingLinearlayoutSellerInfo.visibility=View.GONE
                binding.mainHomeRecommendPostingBtnImgSellerInfo.setImageResource(R.drawable.down_img)
            }
        }


    }



    /*
    광고 배너 자동으로 움직이도록 구현하는 코드
     */
    private fun autoScrollStart(intervalTime: Long) {
        myHandler.removeMessages(0) // 이거 안하면 핸들러가 1개, 2개, 3개 ... n개 만큼 계속 늘어남
        myHandler.sendEmptyMessageDelayed(0, intervalTime) // intervalTime 만큼 반복해서 핸들러를 실행하게 함
    }

    /*
    핸들러를 중지시키는 코드
     */
    private fun autoScrollStop(){
        myHandler.removeMessages(0) // 핸들러를 중지시킴
    }


    private inner class MyHandler : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if(msg.what == 0) {
                binding.mainHomeRecommendViewPager2Ad.setCurrentItem(++currentPosition, true) // 다음 페이지로 이동
                autoScrollStart(intervalTime) // 스크롤을 계속 이어서 한다.
            }
        }
    }

    // 다른 페이지 갔다가 돌아오면 다시 스크롤 시작
    override fun onResume() {
        super.onResume()
        autoScrollStart(intervalTime)
    }

    // 다른 페이지로 떠나있는 동안 스크롤이 동작할 필요는 없음. 정지
    override fun onPause() {
        super.onPause()
        autoScrollStop()
    }

}
