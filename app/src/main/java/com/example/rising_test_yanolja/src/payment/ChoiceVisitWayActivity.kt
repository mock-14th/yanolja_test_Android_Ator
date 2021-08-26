package com.example.rising_test_yanolja.src.payment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.BaseActivity
import com.example.rising_test_yanolja.databinding.ActivityChoiceVisitWayBinding

class ChoiceVisitWayActivity :BaseActivity<ActivityChoiceVisitWayBinding>(ActivityChoiceVisitWayBinding::inflate) {

    var startDate = " "
    var endDate =" "
    var roomType = " "
    var checkIn = " "
    var checkOut = " "
    var brandName = " "
    var startDayOfWeek =" "
    var endDayOfWeek = " "
    var oneDayPrice =" "
    var isCheck = "도보"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        binding.paymentTxPeriod.text="${startDate} (${startDayOfWeek}) ~ ${endDate} (${endDayOfWeek})"
        binding.paymentTxRoomType.text=roomType

        binding.btnWalk.setOnClickListener {
            binding.btnCar.setBackgroundResource(R.drawable.payment_gray_stroke_right_btn_round)
            binding.btnWalk.setBackgroundResource(R.drawable.payment_blue_stroke_left_btn_round)
            isCheck="도보"
            binding.btnOk.isEnabled=true
        }

        binding.btnCar.setOnClickListener {
            binding.btnCar.setBackgroundResource(R.drawable.payment_blue_stroke_right_btn_round)
            binding.btnWalk.setBackgroundResource(R.drawable.payment_gray_stroke_left_btn_round)
            isCheck="차량"
            binding.btnOk.isEnabled=true
        }

        binding.btnOk.setOnClickListener {
            var resultIntent = Intent()
            resultIntent.putExtra("result",isCheck)
            setResult(Activity.RESULT_OK,resultIntent)
            finish()
        }

        binding.bookingLeftImg.setOnClickListener {
            finish()
        }

    }
}