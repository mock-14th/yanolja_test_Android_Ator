package com.example.rising_test_yanolja.src.productInfo

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.BaseActivity
import com.example.rising_test_yanolja.databinding.ActivityProductInfoBinding
import com.example.rising_test_yanolja.src.main.myNear.sub.Product.MyNearSubProductService
import com.example.rising_test_yanolja.src.productInfo.models.*


class ProductInfoActivity :
    BaseActivity<ActivityProductInfoBinding>(ActivityProductInfoBinding::inflate),
    ProductInfoActivityView {

    private var thumnailList = ArrayList<String>()
    private var roomList = ArrayList<Room>()
    private var playthingsList = ArrayList<PlayThingsInfo>()
    private var reviewList = ArrayList<Review>()
    private var brandID = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        brandID = intent.getIntExtra("brandID", 0)
        var handler = Handler(Looper.getMainLooper())

        Thread {
            handler.post {
                showLoadingDialog(this)
                ProductInfoService(this).tryGetProductInfo(brandID, "2021-08-23", "2021-08-24")
            }
        }.start()




        playthingsList.add(
            PlayThingsInfo(
                R.drawable.play_things_img1,
                "[전국] 챔피언 키즈카페\n9개점",
                "10%",
                "5,400"
            )
        )
        playthingsList.add(
            PlayThingsInfo(
                R.drawable.play_things_img2,
                "[경기 고양] 일산\n아쿠아플라넷 (~8/31)",
                "38%%",
                "15,500"
            )
        )
        playthingsList.add(
            PlayThingsInfo(
                R.drawable.play_things_img3,
                "[서울 마포] 홍대\n러브뮤지엄",
                "25%",
                "6,000"
            )
        )
        playthingsList.add(
            PlayThingsInfo(
                R.drawable.play_things_img4,
                "[경기 고양] 아쿠아필드\n루프탑풀...",
                "45%",
                "15,900"
            )
        )
        playthingsList.add(
            PlayThingsInfo(
                R.drawable.play_things_img5,
                "[찜카] 전국 렌터카:\n내륙 할인권",
                "10%",
                "45,000"
            )
        )



        binding.productInfoViewPager2.apply {
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.textViewCurrentBanner.text = "${position + 1}"
                    binding.textViewTotalBanner.text = "${thumnailList.size}"
                }

                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                }
            })
        }


        //놀거리 리사이클러뷰 어댑터 장착
        binding.productInfoRecyclerViewPlayThings.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.productInfoRecyclerViewPlayThings.adapter =
            ProductInfoPlayThingRcAdapter(playthingsList)


        //리뷰 리사이클러뷰 어댑터 장착
        binding.productInfoRecyclerViewReview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.productInfoRecyclerViewReview.adapter = ProductInfoReviewRcAdapter(reviewList)


        //스크롤 뷰 스크롤 리스너임
        binding.productInfoNestedScrollView.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            println(scrollY.toString())
            if (scrollY != 0) {
                binding.productInfoWhiteAppBarLayout.visibility = View.INVISIBLE
                binding.productInfoBlackAppBarLayout.visibility = View.VISIBLE
            } else {
                binding.productInfoWhiteAppBarLayout.visibility = View.VISIBLE
                binding.productInfoBlackAppBarLayout.visibility = View.INVISIBLE
            }
            if (scrollY > 0 && scrollY <= 100f) {
                val alpha = scrollY / 100f
                val resultColor = ColorUtils.blendARGB(
                    ContextCompat.getColor(applicationContext, R.color.statusTrans),
                    ContextCompat.getColor(applicationContext, R.color.white), alpha
                )
                binding.productInfoBlackAppBarLayout.setBackgroundColor(resultColor)

            } else if (scrollY < 10 && oldScrollY > scrollY) {
                binding.productInfoBlackAppBarLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.statusTrans
                    )
                )
            } else if (scrollY > 150f) {
                binding.productInfoBlackAppBarLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.white
                    )
                )
                binding.productInfoBlackAppBarLayout.translationZ = 5f
            }
        }

    }



    //통신 성공
    override fun onGetProductInfoSuccess(response: ProductInfoResponse) {
        if (response.isSuccess) {
            for (i in response.result.roomList)
                roomList.add(i)

            for(i in response.result.reviewList)
                reviewList.add(i)



            //방 정보 리사이클러뷰 어댑터 장착
            binding.productInfoRecyclerView.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.productInfoRecyclerView.adapter = ProductInfoRoomRcAdapter(roomList)



            //리뷰 리사이클러뷰 어댑터 장착
            binding.productInfoRecyclerViewReview.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.productInfoRecyclerViewReview.adapter = ProductInfoReviewRcAdapter(reviewList)



            var brandInfo = response.result.brandInfo
            var reviewList = response.result.reviewList

            binding.productInfoAppbarTxName.text=brandInfo[0].name
            binding.productInfoTxName.text=brandInfo[0].name
            binding.productInfoTxRating.text = brandInfo[0].averageRating
            binding.productInfoTxReviewCountMain.text = brandInfo[0].reviewCount.toString()
            binding.productInfoTxIntroduce.text=brandInfo[0].introduce
            binding.productInfoTxAddress.text=brandInfo[0].address
            binding.productInfoRuleContent.text=brandInfo[0].useInformation
            binding.productInfoTxBigRating.text=brandInfo[0].averageRating
            binding.productInfoReviewCountLast.text=brandInfo[0].reviewCount.toString()
            binding.productInfoReviewAnswer.text="(${brandInfo[0].reviewCount})"

            //var thumnailImg = brandInfo[0].thumnailImg.split(",")


            //thumnailList.add(thumnailImg[0])
            //임의로 사진 추가함
            thumnailList.add("https://firebasestorage.googleapis.com/v0/b/fir-fcm-7df9c.appspot.com/o/images%2Fproduct_thumnail_img1.png?alt=media&token=0c34c305-e8dd-4793-b645-f98d4fd4b3ea")
            thumnailList.add("https://firebasestorage.googleapis.com/v0/b/fir-fcm-7df9c.appspot.com/o/images%2Fproduct_thumnail_img2.png?alt=media&token=e0a5d62a-4bac-4ee9-9aab-f6b48f5ad117")
            thumnailList.add("https://firebasestorage.googleapis.com/v0/b/fir-fcm-7df9c.appspot.com/o/images%2Fproduct_thumnail_img3.png?alt=media&token=05e931c3-9966-492b-952c-87089aacc83e")

            //대표사진 뷰페이저 어댑터 설정
            binding.productInfoViewPager2.adapter = ProductInfoThumnailViewPager2Adapter(thumnailList)
            binding.productInfoViewPager2.orientation =
                ViewPager2.ORIENTATION_HORIZONTAL //스크롤 방향을 가로로 지정





        } else {
            showCustomToast("서버와의 연결이 원할하지 않습니다")
        }
        dismissLoadingDialog()
    }


    //통신 실패
    override fun onGetProductInfoFailure(message: String) {
        showCustomToast("통신 실패")
    }
}