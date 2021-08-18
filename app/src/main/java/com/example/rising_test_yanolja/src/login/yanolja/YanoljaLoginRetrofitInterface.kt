package com.example.rising_test_yanolja.src.login.yanolja

import com.example.rising_test_yanolja.src.login.yanolja.models.LoginResponse
import com.example.rising_test_yanolja.src.login.yanolja.models.PostLoginRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface YanoljaLoginRetrofitInterface {

    @POST("/app/login")
    fun postLogin(@Body params : PostLoginRequest) : Call<LoginResponse>
}