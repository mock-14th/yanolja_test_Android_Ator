package com.example.rising_test_yanolja.src.payment.models

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("bookedNum") val bookedNum:Int,
    @SerializedName("사용가능한 포인트") val bookedName:String,
)
