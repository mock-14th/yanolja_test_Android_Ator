package com.example.rising_test_yanolja.src.main.home.recommend

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.databinding.*
import com.example.rising_test_yanolja.src.main.home.recommend.model.NewHotInfo
import com.example.rising_test_yanolja.src.main.home.recommend.model.NewHotUnderInfo
import com.softsquared.template.kotlin.config.BaseFragment

class HomeRecommendFragment : BaseFragment<FragmentHomeRecommendBinding>(
    FragmentHomeRecommendBinding::bind,
    R.layout.fragment_home_recommend
) {
    private var newHotList = ArrayList<NewHotInfo>()
    private var newHotUnderList = ArrayList<NewHotUnderInfo>()
    private var adImgList = ArrayList<Int>()


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

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //NewHot 리사이클러뷰 어댑터 장착
        binding.mainHomeRecommendRcViewNewHot.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.mainHomeRecommendRcViewNewHot.adapter = HomeRecommendNewHotRcViewAdapter(newHotList)

        //NewHotUnder 리사이클러뷰 어댑터 장착
        binding.mainHomeRecommendRcViewNewHotUnder.layoutManager =
            GridLayoutManager(context,5)
        binding.mainHomeRecommendRcViewNewHotUnder.adapter =HomeRecommendNewHotUnderRcViewAdapter(newHotUnderList)

        //Ad viewPager 어댑터 장착
        binding.mainHomeRecommendViewPager2Ad.adapter = HomeRecommendAdViewPager2Adapter(adImgList)
        binding.mainHomeRecommendViewPager2Ad.orientation = ViewPager2.ORIENTATION_HORIZONTAL //스크롤 방향을 가로로 지정

    }
}
