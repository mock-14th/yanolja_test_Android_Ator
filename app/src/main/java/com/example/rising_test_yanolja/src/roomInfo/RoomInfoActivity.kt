package com.example.rising_test_yanolja.src.roomInfo

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.viewpager2.widget.ViewPager2
import com.example.rising_test_yanolja.config.BaseActivity
import com.example.rising_test_yanolja.databinding.ActivityRoomInfoBinding
import com.example.rising_test_yanolja.src.booking.BookingActivity
import com.example.rising_test_yanolja.src.roomInfo.models.RoomInfoResponse
import com.example.rising_test_yanolja.src.roomInfo.models.RoomPhoneNumResponse
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class RoomInfoActivity : BaseActivity<ActivityRoomInfoBinding>(ActivityRoomInfoBinding::inflate),RoomInfoActivityView {

    var roomImgList = ArrayList<String>()
    var startDate = " "
    var endDate =" "
    var brandID = 0
    var roomType = " "
    var checkIn = " "
    var checkOut = " "
    var brandName = " "
    var halfDayPrice = " "
    var oneDayPrice =" "
    var checkInText = ""
    var checkOutText = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startDate = intent.getStringExtra("startDate").toString()
        endDate = intent.getStringExtra("endDate").toString()
        brandID = intent.getIntExtra("brandID",0)
        roomType = intent.getStringExtra("roomType").toString()
        checkInText = intent.getStringExtra("checkInText").toString()
        checkOutText = intent.getStringExtra("checkOutText").toString()
        println("startDate 값은? : $startDate")
        var handler = Handler(Looper.getMainLooper())

        Thread {
            handler.post {
                showLoadingDialog(this)
                RoomInfoService(this).tryGetRoomInfo(startDate,endDate,roomType,brandID)
            }
        }.start()



        var ccii = startDate.split("-")
        var cciiToday = getDateDay("${ccii[0]}${ccii[1]}${ccii[2]}","yyyyMMdd")
        binding.productInfoTxCheckIn.text= checkInText
        binding.productInfoTxCheckOut.text=checkOutText


        //뷰페이저 현재 사진과 전체 사진 갯수 출력
        binding.roomInfoViewPager2.apply {
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.textViewCurrentBanner.text = "${position + 1}"
                    binding.textViewTotalBanner.text = "${roomImgList.size}"
                }

                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                }
            })
        }


        //appbarlayout의 그림자 효과를 스크롤 최상단에서만 주기 위한 코드
        binding.roomInfoNestedScroolView.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if(scrollY == 0){
                binding.roomInfoAppBarLayout.translationZ =0f
            }else
                binding.roomInfoAppBarLayout.translationZ =7f
        }


        //대실 클릭 리스너
        binding.roomInfoBtnHalfDay.setOnClickListener {
            if(binding.roomInfoBtnHalfDayBottom.isEnabled){

            }
        }

        //숙박 클릭 리스너
        binding.roomInfoBtnOneDay.setOnClickListener {
            if(binding.roomInfoBtnOneDayBottom.isEnabled){
                var intent = Intent(this,BookingActivity::class.java)
                intent.putExtra("roomType",roomType)
                intent.putExtra("startDate",startDate)
                intent.putExtra("endDate",endDate)
                intent.putExtra("checkIn",checkIn)
                intent.putExtra("checkOut",checkOut)
                intent.putExtra("startDayOfWeek",getDateDay(startDate,"yyyyMMdd"))
                intent.putExtra("endDayOfWeek",getDateDay(endDate,"yyyyMMdd"))
                intent.putExtra("brandName",brandName)
                intent.putExtra("halfDayPrice",halfDayPrice)
                intent.putExtra("oneDayPrice",oneDayPrice)
                startActivity(intent)
            }
        }
    }

    override fun onGetRoomInfoSuccess(response: RoomInfoResponse) {
        if(response.isSuccess){
            var formatter = DecimalFormat("###,###")
            var result = response.result[0]

            checkIn = result.checkIn
            checkOut = result.checkOut
            brandName = result.brandName
            binding.roomInfoTxBrandName.text = result.brandName
            binding.roomInfoTxRoomOption.text = result.roomOption
            binding.roomInfoTxPersonnel.text = result.personnel
            binding.roomInfoTxRoomType.text = result.roomType

            //가격이 예약마감이면 예약마감 출력하고 글씨크기랑 색상 변경
           if(result.halfDayPrice=="예약마감"){
                binding.roomInfoTxHalfDayPrice.text="예약마감"
                binding.roomInfoTxHalfDayPrice.setTextColor(Color.parseColor("#4a4a4a"))
                binding.roomInfoTxHalfDayPrice.textSize=12f
            }else{
                binding.roomInfoBtnHalfDayBottom.isEnabled=true
               binding.roomInfoBtnHalfDayBottom.text="대실 예약하기"
               halfDayPrice=formatter.format(result.halfDayPrice.toInt())
               binding.roomInfoTxHalfDayPrice.text=halfDayPrice
            }
            if(result.oneDayPrice=="예약마감"){
                binding.roomInfoTxOneDayPrice.text="예약마감"
                binding.roomInfoTxOneDayPrice.setTextColor(Color.parseColor("#4a4a4a"))
                binding.roomInfoTxOneDayPrice.textSize=12f
            }else{
                binding.roomInfoBtnOneDayBottom.isEnabled=true
                binding.roomInfoBtnOneDayBottom.text="숙박 예약하기"
                oneDayPrice =formatter.format(result.oneDayPrice.toInt())
                binding.roomInfoTxOneDayPrice.text=oneDayPrice
            }
            binding.roomInfoCheckInTime.text= "${result.checkIn} 부터"
            binding.roomInfoCheckOutTime.text = "${result.checkOut} 부터"

            //이미지 ,기준으로 나눔
            var imgList = result.roomImage.split(",")
            for(i in imgList.indices-(imgList.size-1)){
                roomImgList.add(imgList[i])
            }

            //사진 어댑터 장착
            binding.roomInfoViewPager2.adapter = RoomInfoViewPager2Adapter(roomImgList)
            binding.roomInfoViewPager2.orientation =
                ViewPager2.ORIENTATION_HORIZONTAL //스크롤 방향을 가로로 지정
        }

        dismissLoadingDialog()
    }

    override fun onGetRoomInfoFailure(message: String) {
    }

    override fun onGetRoomPhoneNumSuccess(response: RoomPhoneNumResponse) {
    }

    override fun onGetRoomPhoneNumFailure(message: String) {
    }


    @Throws(Exception::class)
    fun getDateDay(date: String, dateType: String?): String? {
        var changeDate = ""
        var splitResult = date.split("-")
        for(i in splitResult){
            changeDate+=i
        }
        var day = ""
        val dateFormat = SimpleDateFormat(dateType)
        val nDate: Date = dateFormat.parse(changeDate)
        val cal: Calendar = Calendar.getInstance()
        cal.setTime(nDate)
        val dayNum: Int = cal.get(Calendar.DAY_OF_WEEK)
        when (dayNum) {
            1 -> day = "일"
            2 -> day = "월"
            3 -> day = "화"
            4 -> day = "수"
            5 -> day = "목"
            6 -> day = "금"
            7 -> day = "토"
        }
        return day
    }

}