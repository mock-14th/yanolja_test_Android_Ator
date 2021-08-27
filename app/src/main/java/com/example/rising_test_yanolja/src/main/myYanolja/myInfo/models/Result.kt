package com.example.rising_test_yanolja.src.main.myYanolja.myInfo.models

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("폰번호") val phoneNum : String,
    @SerializedName("email") val email :String
)
