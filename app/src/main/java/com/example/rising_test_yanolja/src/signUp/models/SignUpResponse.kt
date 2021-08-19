package com.example.rising_test_yanolja.src.signUp.models

import com.example.rising_test_yanolja.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("result") val result: ResultSignUp
) : BaseResponse()
