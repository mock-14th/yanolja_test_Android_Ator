package com.example.rising_test_yanolja.src.payment.models

import com.google.gson.annotations.SerializedName

data class PostPaymentRequest(
    @SerializedName("brandName") val brandName : String,
    @SerializedName("roomType") val roomType : String,
    @SerializedName("startDate") val startDate:String,
    @SerializedName("endDate") val endDate:String,
    @SerializedName("isWalk") val isWalk:String,
    @SerializedName("memName") val memName:String,
    @SerializedName("userPhone") val userPhone:String,
    @SerializedName("userName") val userName:String,
    @SerializedName("payKind") val payKind:String
)
