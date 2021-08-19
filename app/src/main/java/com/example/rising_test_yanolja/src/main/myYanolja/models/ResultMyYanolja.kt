package com.example.rising_test_yanolja.src.main.myYanolja.models

import com.google.gson.annotations.SerializedName

data class ResultMyYanolja(
    @SerializedName("닉네임") val nickname : String,
    @SerializedName("포인트") val point : String,
    @SerializedName("야놀자코인") val coin : String,
    @SerializedName("쿠폰함") val coupon : Int,
    @SerializedName("장바구니수") val shoppingBasket : Int
)
