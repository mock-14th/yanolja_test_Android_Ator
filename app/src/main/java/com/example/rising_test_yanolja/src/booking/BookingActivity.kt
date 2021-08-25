package com.example.rising_test_yanolja.src.booking

import android.os.Bundle
import com.example.rising_test_yanolja.config.BaseActivity
import com.example.rising_test_yanolja.databinding.ActivityBookingBinding

class BookingActivity : BaseActivity<ActivityBookingBinding>(ActivityBookingBinding::inflate){
    var startDate = " "
    var endDate =" "
    var roomType = " "
    var checkIn = " "
    var checkOut = " "
    var brandName = " "
    var startDayOfWeek =" "
    var endDayOfWeek = " "
    var halfDayPrice = " "
    var oneDayPrice =" "
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
        halfDayPrice = intent.getStringExtra("halfDayPrice").toString()
        oneDayPrice = intent.getStringExtra("oneDayPrice").toString()




        binding.bookingTxRoomType.text=roomType
        binding.bookingTxStartDay.text="${changeDate(startDate)} (${startDayOfWeek})"
        binding.bookingTxCheckInTime.text = checkIn
        binding.bookingTxEndDay.text="${changeDate(endDate)} (${endDayOfWeek})"
        binding.bookingTxCheckOutTime.text = checkOut
        binding.bookingTxCost.text = "${oneDayPrice}원"
    }

    fun changeDate(date:String) : String{
        var splitResult = date.split("-")
        var changeDate = "${splitResult[0]}.${splitResult[1]}.${splitResult[2]}"
        return changeDate
    }
}