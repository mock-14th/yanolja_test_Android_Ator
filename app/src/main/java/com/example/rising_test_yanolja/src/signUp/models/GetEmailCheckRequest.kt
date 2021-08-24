package com.example.rising_test_yanolja.src.signUp.models

import com.google.gson.annotations.SerializedName

data class GetEmailCheckRequest(
    @SerializedName("email") val email : String
)
