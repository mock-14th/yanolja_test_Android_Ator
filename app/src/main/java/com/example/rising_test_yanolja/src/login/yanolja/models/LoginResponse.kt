package com.example.rising_test_yanolja.src.login.yanolja.models

import com.example.rising_test_yanolja.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("result") val result: ResultLogin
): BaseResponse()
