package com.example.rising_test_yanolja.src.main.myYanolja.myInfo.models

import com.google.gson.annotations.SerializedName

data class PostChangeUserRequest(
    @SerializedName("nickname") val nickname:String,
)
