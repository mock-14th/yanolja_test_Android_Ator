package com.example.rising_test_yanolja.src.main.myYanolja.myInfo

import com.example.rising_test_yanolja.config.BaseResponse
import com.example.rising_test_yanolja.src.main.myYanolja.myInfo.models.MyInfoResponse
import com.example.rising_test_yanolja.src.main.myYanolja.myInfo.models.PostChangeUserRequest
import retrofit2.Call
import retrofit2.http.*

interface MyInfoRetrofitInterface {
    @GET("/app/user/email")
    fun getUserEmailPhone(@Header("x-access-token") jwt:String) : Call<MyInfoResponse>

    @PATCH("/app/users/modify")
    fun postChangeUser(@Header("x-access-token") jwt:String, @Body params:PostChangeUserRequest) : Call<BaseResponse>
}