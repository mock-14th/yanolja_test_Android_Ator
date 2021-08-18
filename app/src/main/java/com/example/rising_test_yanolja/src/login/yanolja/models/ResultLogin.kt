package com.example.rising_test_yanolja.src.login.yanolja.models

import com.google.gson.annotations.SerializedName

data class ResultLogin(
    @SerializedName("userId") val userId : String,
    @SerializedName("jwt") val jwt : String
)
