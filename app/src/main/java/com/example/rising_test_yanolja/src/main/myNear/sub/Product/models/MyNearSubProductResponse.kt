package com.example.rising_test_yanolja.src.main.myNear.sub.Product.models

import com.example.rising_test_yanolja.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class MyNearSubProductResponse(
    @SerializedName("result") val result : MutableList<ResultMyNearProduct>
):BaseResponse()
