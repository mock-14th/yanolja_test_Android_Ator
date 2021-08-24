package com.example.rising_test_yanolja.src.signUp

import com.example.rising_test_yanolja.config.BaseResponse

interface SignUpActivity1View {
    fun onGetCheckEmailSuccess(response: BaseResponse)
    fun onGetCheckEmailFailure(message:String)
}