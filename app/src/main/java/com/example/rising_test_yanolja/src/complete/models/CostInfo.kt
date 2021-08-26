package com.example.rising_test_yanolja.src.complete.models

import com.google.gson.annotations.SerializedName

data class CostInfo(
    @SerializedName("주문번호") val bookedNum : Int,
    @SerializedName("예약상품") val bookedBrandName : String,
    @SerializedName("결제수단") val payWay : String,
    @SerializedName("사용포인트") val usePoint : Int,
    @SerializedName("결제금액") val payPrice : String
)
