package com.example.rising_test_yanolja.src.login.yanolja.models

import com.google.gson.annotations.SerializedName

data class PostLoginRequest(
    @SerializedName("email") val email : String,
    @SerializedName("password") val password : String
)
