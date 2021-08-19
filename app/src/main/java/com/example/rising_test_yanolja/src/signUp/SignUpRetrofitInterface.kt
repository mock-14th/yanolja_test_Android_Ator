package com.example.rising_test_yanolja.src.signUp

import com.example.rising_test_yanolja.src.signUp.models.PostSignUpRequest
import com.example.rising_test_yanolja.src.signUp.models.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SignUpRetrofitInterface {
    @POST("/app/users")
    fun postSignUp(@Body params : PostSignUpRequest): Call<SignUpResponse>

}