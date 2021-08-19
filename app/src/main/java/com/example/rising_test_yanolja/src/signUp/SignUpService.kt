package com.example.rising_test_yanolja.src.signUp

import com.example.rising_test_yanolja.config.ApplicationClass
import com.example.rising_test_yanolja.src.signUp.models.PostSignUpRequest
import com.example.rising_test_yanolja.src.signUp.models.SignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class SignUpService(val view : SignUpActivity2View) {

    fun tryPostSignUp(postSignUpRequest: PostSignUpRequest){
        val signUpRetrofitInterface = ApplicationClass.sRetrofit.create(SignUpRetrofitInterface::class.java)
        signUpRetrofitInterface.postSignUp(postSignUpRequest).enqueue(object : Callback<SignUpResponse> {
            override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
                view.onPostSignUpSuccess(response.body() as SignUpResponse)
            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                view.onPostSignUpFailure(t.message ?: "통신 오류")
            }

        })
    }

}

