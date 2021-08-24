package com.example.rising_test_yanolja.src.signUp

import com.example.rising_test_yanolja.config.ApplicationClass
import com.example.rising_test_yanolja.config.BaseResponse
import com.example.rising_test_yanolja.src.signUp.models.GetEmailCheckRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUp1Service(val view : SignUpActivity1View) {
    fun tryGetEmailCheck(getEmailCheckRequest: GetEmailCheckRequest){
        val signUpRetrofitInterface = ApplicationClass.sRetrofit.create(SignUpRetrofitInterface::class.java)
        signUpRetrofitInterface.getEmailCheck(getEmailCheckRequest).enqueue(object  :
            Callback<BaseResponse> {
            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                view.onGetCheckEmailSuccess(response.body() as BaseResponse)
            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                view.onGetCheckEmailFailure(t.message ?: "통신 오류")
            }
        })
    }
}