package com.example.rising_test_yanolja.src.payment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.ApplicationClass.Companion.sSharedPreferences
import com.example.rising_test_yanolja.config.BaseActivity
import com.example.rising_test_yanolja.databinding.ActivityPaymentBinding
import com.example.rising_test_yanolja.src.complete.CompleteActivity
import com.example.rising_test_yanolja.src.payment.models.PaymentResponse
import com.example.rising_test_yanolja.src.payment.models.PhoneNumResponse
import com.example.rising_test_yanolja.src.payment.models.PostPaymentRequest

class PaymentActivity:BaseActivity<ActivityPaymentBinding>(ActivityPaymentBinding::inflate),PaymentActivityView {
    var startDate = " "
    var endDate =" "
    var roomType = " "
    var checkIn = " "
    var checkOut = " "
    var brandName = " "
    var startDayOfWeek =" "
    var endDayOfWeek = " "
    var oneDayPrice =" "

    var payKind="카카오페이"
    var isCheckSameUser = false
    var isShowProductInfo =false
    private lateinit var JWT : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        JWT = sSharedPreferences.getString("X_ACCESS_TOKEN","").toString()

        //폰번호 불러오는 api호출
        PaymentService(this).tryGetPhoneNum(JWT)

        startDate = intent.getStringExtra("startDate").toString()
        endDate = intent.getStringExtra("endDate").toString()
        roomType = intent.getStringExtra("roomType").toString()
        checkIn = intent.getStringExtra("checkIn").toString()
        checkOut = intent.getStringExtra("checkOut").toString()
        brandName = intent.getStringExtra("brandName").toString()
        startDayOfWeek = intent.getStringExtra("startDayOfWeek").toString()
        endDayOfWeek = intent.getStringExtra("endDayOfWeek").toString()
        oneDayPrice = intent.getStringExtra("oneDayPrice").toString()


        binding.paymentTxBrandName.text=brandName
        binding.paymentTxCheckInTime.text = "체크인 ${checkIn}"
        binding.paymentTxCheckOutTiem.text = "체크아웃 ${checkOut}"
        binding.paymentTxPeriod.text="${startDate} (${startDayOfWeek}) ~ ${endDate} (${endDayOfWeek})"
        binding.paymentTxRoomType.text=roomType
        binding.paymentTxPrice.text=oneDayPrice
        binding.paymentTxPrice2.text="${oneDayPrice}원"
        binding.paymentTxPrice3.text=oneDayPrice
        binding.paymentBtnPay.text="${oneDayPrice}원 결제하기"


        //클릭 시 상품 정보 확인 가능
        binding.paymentBtnShowProductInfo.setOnClickListener {
            if(isShowProductInfo){
                isShowProductInfo=false
                binding.paymentBtnShowProductInfo.setImageResource(R.drawable.down_black_img)
                binding.paymentConstraintLayoutShowProductInfo.visibility=View.GONE
            }else{
                isShowProductInfo=true
                binding.paymentBtnShowProductInfo.setImageResource(R.drawable.up_black_img)
                binding.paymentConstraintLayoutShowProductInfo.visibility=View.VISIBLE
            }

        }


        //appbarlayout의 그림자 효과를 스크롤 최상단에서만 주기 위한 코드
        binding.paymentNestedScrollView.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if(scrollY == 0){
                binding.paymentAppBarLayout.translationZ =0f
            }else
                binding.paymentAppBarLayout.translationZ =7f
        }


        //체크 시 예약자 정보를 이용자 정보로 넘겨줌
        binding.paymentBtnCheckSameUser.setOnClickListener {
            if(isCheckSameUser){
                isCheckSameUser=false
                binding.paymentBtnCheckSameUser.setImageResource(R.drawable.bottom_sheet_round_check_img)
                binding.paymentEdtName2.text.clear()
            }else{
                isCheckSameUser=true
                binding.paymentBtnCheckSameUser.setImageResource(R.drawable.bottom_sheet_round_check_blue_img)
                binding.paymentEdtName2.text = binding.paymentEdtName.text
            }
        }


        binding.paymentBtnKakaopay.setOnClickListener(btnClickListener)
        binding.paymentBtnToss.setOnClickListener(btnClickListener)
        binding.paymentBtnCard.setOnClickListener(btnClickListener)
        binding.paymentBtnChai.setOnClickListener(btnClickListener)


        //결제하기 버튼 리스너
        binding.paymentBtnPay.setOnClickListener {
            showLoadingDialog(this)
            PaymentService(this).tryPostBookedInfo(JWT,PostPaymentRequest(brandName = brandName,roomType = roomType,startDate = startDate,
            endDate = endDate,isWalk =binding.paymentTxVisitingMeans.text.toString() ,memName = binding.paymentEdtName.text.toString(),userPhone = binding.paymentEdtPhone2.text.toString(),
            userName = binding.paymentEdtName2.text.toString(),payKind = payKind))
        }



        //방문 수단 선택하기 버튼
        binding.paymentBtnChoiceVisitWay.setOnClickListener {
            var intent=Intent(this,ChoiceVisitWayActivity::class.java)
            intent.putExtra("brandName",brandName)
            intent.putExtra("roomType",roomType)
            intent.putExtra("startDate",startDate)
            intent.putExtra("endDate",endDate)
            intent.putExtra("startDayOfWeek",startDayOfWeek)
            intent.putExtra("endDayOfWeek",endDayOfWeek)
            startActivityForResult(intent,101)
        }

    }


    /*
    좌측 메뉴 버튼 클릭 리스너
     */
    val btnClickListener: View.OnClickListener = object : View.OnClickListener {
        override fun onClick(v: View?) {
            allPressedFalse()
            when(v){
                binding.paymentBtnKakaopay->{
                    binding.paymentBtnKakaopay.setImageResource(R.drawable.checked_img)
                    binding.paymentTxChoicePayContent.text="은행 점검시간인 23:30~00:30 까지 이용 불가한 계좌이체 결제수단이 포함되어 있습니다."
                    binding.paymentTxChoicePay.text="카카오페이"
                    payKind="카카오페이"
                }
                binding.paymentBtnToss->{
                    binding.paymentBtnToss.setImageResource(R.drawable.checked_img)
                    binding.paymentTxChoicePayContent.text="은행 점검시간인 23:30~00:30 까지 이용 불가한 결제수단입니다."
                    binding.paymentTxChoicePay.text="토스"
                    payKind="토스"
                }
                binding.paymentBtnCard->{
                    binding.paymentBtnCard.setImageResource(R.drawable.checked_img)
                    binding.paymentTxChoicePayContent.text="할부는 5만원 이상 결제 시 가능합니다."
                    binding.paymentTxChoicePay.text="카드"
                    payKind="카드"
                }
                binding.paymentBtnChai->{
                    binding.paymentBtnChai.setImageResource(R.drawable.checked_img)
                    binding.paymentTxChoicePayContent.text="은행 점검시간인 23:30~00:30 까지 이용 불가한 결제수단입니다."
                    binding.paymentTxChoicePay.text="차이"
                    payKind="차이"
                }

            }
        }

    }



    /*
     모든 결제 수단 선택 버튼을 unCehck이미지로 변환하는 함수
     */
    fun allPressedFalse(){
        binding.paymentBtnKakaopay.setImageResource(R.drawable.uncheck_img)
        binding.paymentBtnToss.setImageResource(R.drawable.uncheck_img)
        binding.paymentBtnCard.setImageResource(R.drawable.uncheck_img)
        binding.paymentBtnChai.setImageResource(R.drawable.uncheck_img)
    }



    /*
    통신 성공
     */
    override fun onPostBookedInfoSuccess(response: PaymentResponse) {
        println("뭘 받냐: ${response.isSuccess}")
        if(response.isSuccess){
            showCustomToast(response.result[0].bookedNum.toString())

            var bookedNum :Int = response.result[0].bookedNum as Int
            var editor = sSharedPreferences.edit()
            editor.putInt("bookedNum",bookedNum)
            editor.apply()

            //결과 화면으로 이동
            var intent = Intent(this,CompleteActivity::class.java)
            intent.putExtra("bookedNum",bookedNum)
            startActivity(intent)

        }
        else{
            showCustomToast(response.message.toString())
        }
        dismissLoadingDialog()
    }

    /*
    통신 실패
     */
    override fun onPostBookInfoFailure(message: String) {
        showCustomToast(message)
        dismissLoadingDialog()
    }


    /*
   폰 번호 가져오기 통신 성공
   */
    override fun onGetPhoneNumSuccess(response: PhoneNumResponse) {
        if (response.isSuccess){
            binding.paymentTxPhonenum.text=response.result[0].phoneNum
            binding.paymentEdtPhone2.setText(response.result[0].phoneNum)
        }
    }

    /*
    폰 번호 가져오기 통신 실패
    */
    override fun onGetPhoneNumFailure(message: String) {
    }

    /*
    숙소 방문 수단 돌려받기
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(101, resultCode, data)
        if(resultCode== Activity.RESULT_OK){
            val result = data!!.getStringExtra("result")
            binding.paymentTxVisitingMeans.text=result
        }
    }
}