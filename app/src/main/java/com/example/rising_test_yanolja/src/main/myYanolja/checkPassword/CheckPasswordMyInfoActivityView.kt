package com.example.rising_test_yanolja.src.main.myYanolja.checkPassword

import retrofit2.Call

interface CheckPasswordMyInfoActivityView {
    fun onGetCheckPasswordSuccess(response:CheckPasswordResponse)
    fun onGetCheckPasswordFailure(message:String)
}