package com.example.rising_test_yanolja.src.main.myYanolja.myInfo.models

import com.example.rising_test_yanolja.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class MyInfoResponse(
    @SerializedName("result") val result : List<Result>
):BaseResponse()
