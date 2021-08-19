package com.example.rising_test_yanolja.src.signUp.models

import com.google.gson.annotations.SerializedName

data class PostSignUpRequest(
    @SerializedName("nickname") val nickname : String,
    @SerializedName("email") val email : String,
    @SerializedName("phone") val phone : String,
    @SerializedName("password") val password : String
    )
