package com.example.rising_test_yanolja.src.main.myYanolja.checkPassword

import com.example.rising_test_yanolja.config.BaseResponse
import com.example.rising_test_yanolja.src.main.myYanolja.checkPassword.models.PostCheckPasswordRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface CheckPasswordMyInfoRetrofitInterface {
    @POST("/app/password-check")
    fun postCheckPassword(@Header("x-access-token")jwt:String,@Body params : PostCheckPasswordRequest) : Call<BaseResponse>
}