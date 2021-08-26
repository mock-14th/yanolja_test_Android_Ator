package com.example.rising_test_yanolja.src.complete.models

import com.example.rising_test_yanolja.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class CompleteResponse(
    @SerializedName("result") val result : Result
):BaseResponse()
