package com.example.rising_test_yanolja.src.main.myYanolja.checkPassword

import com.example.rising_test_yanolja.config.BaseResponse
import retrofit2.Call

interface CheckPasswordMyInfoActivityView {
    fun onPostCheckPasswordSuccess(response:BaseResponse)
    fun onPostCheckPasswordFailure(message:String)
}