package com.example.rising_test_yanolja.src.complete

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.ApplicationClass
import com.example.rising_test_yanolja.config.BaseActivity
import com.example.rising_test_yanolja.databinding.ActivityCompleteBinding
import com.example.rising_test_yanolja.src.complete.models.CompleteResponse
import com.example.rising_test_yanolja.src.main.MainActivity
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

class CompleteActivity : BaseActivity<ActivityCompleteBinding>(ActivityCompleteBinding::inflate),CompleteActivityView {

    var isShowProductInfo = false
    var isShowBookerInfo = false

    private lateinit var JWT : String
    var bookedNum = 0
    var formatter = DecimalFormat("###,###")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        JWT = ApplicationClass.sSharedPreferences.getString("X_ACCESS_TOKEN","").toString()
        bookedNum = intent.getIntExtra("bookedNum",0)


        CompleteService(this).tryOnPostPayInfo(JWT,bookedNum,0)

        //appbarlayout의 그림자 효과를 스크롤 최상단에서만 주기 위한 코드
        binding.nested.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if(scrollY == 0){
                binding.paymentAppBarLayout.translationZ =0f
            }else
                binding.paymentAppBarLayout.translationZ =7f
        }


        //상품 정보 더보기 버튼 리스너
        binding.completeBtnShowProductInfo.setOnClickListener {
            if(isShowProductInfo){
                isShowProductInfo=false
                binding.completeBtnShowProductInfo.setImageResource(R.drawable.down_black_img)
                binding.paymentConstraintLayoutShowProductInfo.visibility= View.GONE

            }else{
                isShowProductInfo=true
                binding.completeBtnShowProductInfo.setImageResource(R.drawable.up_black_img)
                binding.paymentConstraintLayoutShowProductInfo.visibility= View.VISIBLE
            }
        }


        //예약자 정보 더보기 버튼 리스너
        binding.completeBtnShowBookerInfo.setOnClickListener {
            if(isShowBookerInfo){
                isShowBookerInfo=false
                binding.completeBtnShowBookerInfo.setImageResource(R.drawable.down_black_img)
                binding.completeConstraintLayoutBookerInfo.visibility= View.GONE

            }else{
                isShowBookerInfo=true
                binding.completeBtnShowBookerInfo.setImageResource(R.drawable.up_black_img)
                binding.completeConstraintLayoutBookerInfo.visibility= View.VISIBLE
            }
        }


        //홈으로 가기 버튼 리스너
        binding.completeBtnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("currentViewPagerIndex",2)
            startActivity(intent)
            finish()
        }

    }

    override fun onPostPayInfoSuccess(response: CompleteResponse) {

        if(response.isSuccess){
            var completeTime = response.result.result2[0].completeTime.split(" ")

            //받아온 예약일시 공백 제거하는 라인
            var template = response.result.result2[0].completeTime.trim()

            binding.completeTxBookedTime.text="예약일시: ${completeTime[0]}.${completeTime[1]}.${completeTime[2]} (${getDateDay(template,"yyyyMMdd")}) ${completeTime[3]}"

            Glide.with(binding.root).load(response.result.productInfo.roomThumnail).into(binding.completeImgThumnail)
            binding.completeTxBrandName.text=response.result.productInfo.brandName
            binding.completeTxRoomType.text=response.result.productInfo.roomType

            //이용날짜 잘라서 요일 붙혀주기 위함
            var template2 = response.result.productInfo.visitDay.split("~")
            var checkInTemplate = template2[0].replace("-","")
            var checkOutTemplate = template2[1].replace("-","")

            binding.completeTxPeriod.text="${template2[0].replace("-",".")} (${getDateDay(checkInTemplate,"yyyyMMdd")}) ~ ${template2[1].replace("-",".")} (${getDateDay(checkOutTemplate,"yyyyMMdd")})"

            //체크인 시간과 체크 아웃 시간을 나누기 위함
            var template3 = response.result.productInfo.checkInOut.split(",")
            binding.completeTxCheckInTime.text=template3[0]
            binding.completeTxCheckOutTime.text=template3[1]


            //예약자 정보 나누기 위함
            var template4 = response.result.bookerInfo.bookerInfo.split(", ")
            var template4_name = template4[0].split(": ")
            var template4_phone = template4[1].split(": ")

            binding.completeTxUserPhone.text=template4_phone[1]
            binding.completeTxUserName.text=template4_name[1]



            //이용자 정보 나누기 위함
            var template5 = response.result.userInfo.userInfo.split(", ")
            var template5_name = template5[0].split(": ")
            var template5_phone = template5[1].split(": ")

            binding.completeTxUserName2.text=template5_name[1]
            binding.completeTxUserPhone2.text=template5_phone[1]

            binding.completeTxBookedID.text="Y210822ITUZ${response.result.costInfo.bookedNum}"
            binding.completeTxBrandName2.text=response.result.costInfo.bookedBrandName
            binding.completeTxPayWay.text=response.result.costInfo.payWay

            binding.completeTxPayCost.text="${formatter.format(response.result.costInfo.payPrice.toInt())}원"



        }else{
            showCustomToast("오류 발생")
        }


    }

    override fun onPostPayInfoFailure(message: String) {

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