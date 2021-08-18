package com.example.rising_test_yanolja.src.login.yanolja

import com.example.rising_test_yanolja.config.ApplicationClass
import com.example.rising_test_yanolja.src.login.yanolja.models.LoginResponse
import com.example.rising_test_yanolja.src.login.yanolja.models.PostLoginRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YanoljaLoginService(val view: YanoljaLoginFragmentView) {

    fun tryPostLogin(postLoginRequest: PostLoginRequest){
        val yanoljaLoginRetrofitInterface = ApplicationClass.sRetrofit.create(YanoljaLoginRetrofitInterface::class.java)
        yanoljaLoginRetrofitInterface.postLogin(postLoginRequest).enqueue(object : Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                view.onPostLoginSuccess(response.body() as LoginResponse)
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                view.onPostLoginFailure(t.message ?: "통신 오류")
            }
        })
    }

}