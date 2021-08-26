package com.example.rising_test_yanolja.src.main.myYanolja.checkReservation

import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.rising_test_yanolja.config.ApplicationClass.Companion.sSharedPreferences
import com.example.rising_test_yanolja.config.BaseActivity
import com.example.rising_test_yanolja.databinding.ActivityCheckReservationBinding
import com.example.rising_test_yanolja.src.main.myYanolja.checkReservation.models.CheckReservationResponse
import java.text.SimpleDateFormat
import java.util.*

class CheckReservationActivity : BaseActivity<ActivityCheckReservationBinding>(ActivityCheckReservationBinding::inflate), CheckReservationActivityView {

    var bookedNum = 0
    private lateinit var JWT : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bookedNum = sSharedPreferences.getInt("bookedNum",0)
        JWT = sSharedPreferences.getString("X_ACCESS_TOKEN","").toString()

        CheckReservationService(this).tryGetReservation(JWT,bookedNum)
    }


    /*
    통신 성공
     */
    override fun onGetReservationSuccess(response: CheckReservationResponse) {
        if (response.isSuccess){

            Glide.with(binding.root).load(response.result.productInfo.roomThumnail).into(binding.checkReservationImgThumnail)
            binding.completeTxBrandName.text=response.result.productInfo.brandName
            binding.completeTxRoomType.text=response.result.productInfo.roomType
            binding.checkReservationTxBookedNum.text = "21082604526300${response.result.bookedNum}"


            //이용날짜 잘라서 요일 붙혀주기 위함
            var template2 = response.result.productInfo.visitDay.split("~")
            var checkInTemplate = template2[0].replace("-","")
            var checkOutTemplate = template2[1].replace("-","")

            binding.completeTxPeriod.text="${template2[0].replace("-",".")} (${getDateDay(checkInTemplate,"yyyyMMdd")}) ~ ${template2[1].replace("-",".")} (${getDateDay(checkOutTemplate,"yyyyMMdd")})"

            //체크인 시간과 체크 아웃 시간을 나누기 위함
            var template3 = response.result.productInfo.checkInOut.split(",")
            binding.completeTxCheckInTime.text=template3[0]
            binding.completeTxCheckOutTime.text=template3[1]

            binding.checkReservationBookedTime.text="${response.result.productInfo.bookedTime} ${response.result.productInfo.bookedToday}"
        }else{
            showCustomToast("결과 실패")
        }
    }

    override fun onGetReservationFailure(message: String) {
        showCustomToast(message)
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