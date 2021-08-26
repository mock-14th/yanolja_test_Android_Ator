package com.example.rising_test_yanolja.src.complete.models

import com.example.rising_test_yanolja.src.productInfo.models.ProductInfoResponse
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("결과") val result2:List<Result2>,
    @SerializedName("상품 및 이용정보:") val productInfo : ProductInfo,
    @SerializedName("예약자 정보") val bookerInfo : BookerInfo,
    @SerializedName("이용자 정보") val userInfo : UserInfo,
    @SerializedName("금액 및 할인 정보") val costInfo : CostInfo
)
