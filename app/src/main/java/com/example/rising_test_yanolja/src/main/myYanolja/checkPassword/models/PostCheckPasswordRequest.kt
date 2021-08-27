package com.example.rising_test_yanolja.src.main.myYanolja.checkPassword.models

import com.google.gson.annotations.SerializedName

data class PostCheckPasswordRequest(
    @SerializedName("password") val password : String
)
