package com.example.rising_test_yanolja.src.productInfo

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.BaseActivity
import com.example.rising_test_yanolja.databinding.ActivityProductInfoBinding


class ProductInfoActivity : BaseActivity<ActivityProductInfoBinding>(ActivityProductInfoBinding::inflate){

    private var thumnailList = ArrayList<Int>()
    private var roomList = ArrayList<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        thumnailList.add(R.drawable.product_thumnail_img1)
        thumnailList.add(R.drawable.product_thumnail_img2)
        thumnailList.add(R.drawable.product_thumnail_img3)

        roomList.add(R.drawable.product_thumnail_img1)
        roomList.add(R.drawable.product_thumnail_img1)
        roomList.add(R.drawable.product_thumnail_img1)
        roomList.add(R.drawable.product_thumnail_img1)
        roomList.add(R.drawable.product_thumnail_img1)
        roomList.add(R.drawable.product_thumnail_img1)


        //대표사진 뷰페이저 어댑터 설정
        binding.productInfoViewPager2.adapter=ProductInfoThumnailViewPager2Adapter(thumnailList)
        binding.productInfoViewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL //스크롤 방향을 가로로 지정

        binding.productInfoViewPager2.apply {
            registerOnPageChangeCallback(object:ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                        binding.textViewCurrentBanner.text = "${position+1}"
                        binding.textViewTotalBanner.text = "${thumnailList.size}"
                }
                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                }
            })
        }



        //방 정보 리사이클러뷰 어댑터 장착
        binding.productInfoRecyclerView.layoutManager=LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.productInfoRecyclerView.adapter=ProductInfoRoomRcAdapter(roomList)



        //스크롤 뷰 스크롤 리스너임
        binding.productInfoNestedScrollView.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            println(scrollY.toString())
            if(scrollY != 0){
                binding.productInfoWhiteAppBarLayout.visibility=View.INVISIBLE
                binding.productInfoBlackAppBarLayout.visibility=View.VISIBLE
            }else{
                binding.productInfoWhiteAppBarLayout.visibility=View.VISIBLE
                binding.productInfoBlackAppBarLayout.visibility= View.INVISIBLE
            }
            if(scrollY > 0 && scrollY <= 100f){
                val alpha = scrollY /100f
                val resultColor = ColorUtils.blendARGB(ContextCompat.getColor(applicationContext, R.color.statusTrans),
                    ContextCompat.getColor(applicationContext, R.color.white), alpha)
                binding.productInfoBlackAppBarLayout.setBackgroundColor(resultColor)

            }else if(scrollY < 10 && oldScrollY>scrollY){
                binding.productInfoBlackAppBarLayout.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.statusTrans))
            }else if (scrollY>150f){
                binding.productInfoBlackAppBarLayout.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.white))
                binding.productInfoBlackAppBarLayout.translationZ=5f
            }
        }

    }
}