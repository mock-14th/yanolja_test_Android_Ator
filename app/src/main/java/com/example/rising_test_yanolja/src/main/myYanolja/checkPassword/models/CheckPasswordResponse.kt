package com.example.rising_test_yanolja.src.main.myYanolja.checkPassword.models

import com.example.rising_test_yanolja.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class CheckPasswordResponse(
    @SerializedName("result") val result : List<Result>
):BaseResponse()
