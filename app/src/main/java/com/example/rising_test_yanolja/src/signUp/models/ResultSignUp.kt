package com.example.rising_test_yanolja.src.signUp.models

import com.google.gson.annotations.SerializedName

data class ResultSignUp(
    @SerializedName("추가된 회원") val userId : String,
    @SerializedName("닉네임") val nickname : String,
    @SerializedName("jwt") val jwt : String
)
