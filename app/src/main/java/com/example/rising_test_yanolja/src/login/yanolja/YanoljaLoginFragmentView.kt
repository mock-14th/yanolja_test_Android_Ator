package com.example.rising_test_yanolja.src.login.yanolja

import com.example.rising_test_yanolja.src.login.yanolja.models.LoginResponse

interface YanoljaLoginFragmentView {

    fun onPostLoginSuccess(response: LoginResponse)
    fun onPostLoginFailure(message: String)

}