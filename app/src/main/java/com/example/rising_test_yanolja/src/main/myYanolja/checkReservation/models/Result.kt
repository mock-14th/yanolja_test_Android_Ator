package com.example.rising_test_yanolja.src.main.myYanolja.checkReservation.models


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("예약번호") val bookedNum : String,
    @SerializedName("상품 및 이용정보:") val productInfo : ProductInfo,
    @SerializedName("예약자 정보") val bookerInfo : BookerInfo,
    @SerializedName("이용자 정보") val userInfo : UserInfo,
    @SerializedName("금액 및 할인 정보") val costInfo : CostInfo
)

