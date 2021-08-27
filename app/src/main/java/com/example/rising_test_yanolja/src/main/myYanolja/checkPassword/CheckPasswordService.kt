package com.example.rising_test_yanolja.src.main.myYanolja.checkPassword

import com.example.rising_test_yanolja.config.ApplicationClass
import com.example.rising_test_yanolja.config.BaseResponse
import com.example.rising_test_yanolja.src.main.myYanolja.checkPassword.models.PostCheckPasswordRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CheckPasswordService(val view:CheckPasswordMyInfoActivityView) {
    fun tryPostCheckPassword(jwt:String,postCheckPasswordRequest: PostCheckPasswordRequest){
        val checkPasswordMyInfoRetrofitInterface = ApplicationClass.sRetrofit.create(CheckPasswordMyInfoRetrofitInterface::class.java)
        checkPasswordMyInfoRetrofitInterface.postCheckPassword(jwt,postCheckPasswordRequest).enqueue(object:Callback<BaseResponse>{
            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                view.onPostCheckPasswordSuccess(response.body() as BaseResponse)
            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                view.onPostCheckPasswordFailure(t.message ?: "통신 오류")
            }

        })
    }
}