package com.example.rising_test_yanolja.src.main.myYanolja.models

import com.example.rising_test_yanolja.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class MyYanoljaResponse(
    @SerializedName("result") val result : ResultMyYanolja
):BaseResponse()
