package com.example.rising_test_yanolja.src.main.like.models

import com.example.rising_test_yanolja.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class LikeProductResponse(
    @SerializedName("result") val result : List<Result>
):BaseResponse()
