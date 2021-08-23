package com.example.rising_test_yanolja.src.productInfo.models

import com.google.gson.annotations.SerializedName

data class ProductInfoResponse(
    @SerializedName("code") val code: Int,
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: result
)