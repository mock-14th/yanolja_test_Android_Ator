package com.example.rising_test_yanolja.src.main.myYanolja.checkReservation.models

import com.google.gson.annotations.SerializedName

data class ProductInfo(
    @SerializedName("방썸네일") val roomThumnail : String,
    @SerializedName("brandName") val brandName : String,
    @SerializedName("roomType") val roomType : String,
    @SerializedName("roomOption") val roomOption : String,
    @SerializedName("이용날짜") val visitDay : String,
    @SerializedName("체크인아웃") val checkInOut:String,
    @SerializedName("예약일시") val bookedTime:String,
    @SerializedName("예약요일") val bookedToday :String
)
