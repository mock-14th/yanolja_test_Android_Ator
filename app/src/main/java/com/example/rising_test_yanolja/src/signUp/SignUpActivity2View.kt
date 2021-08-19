package com.example.rising_test_yanolja.src.signUp

import com.example.rising_test_yanolja.src.login.yanolja.models.LoginResponse
import com.example.rising_test_yanolja.src.signUp.models.SignUpResponse

interface SignUpActivity2View {
        fun onPostSignUpSuccess(response: SignUpResponse)
    fun onPostSignUpFailure(message: String)


}