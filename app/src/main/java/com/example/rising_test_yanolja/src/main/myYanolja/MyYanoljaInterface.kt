package com.example.rising_test_yanolja.src.main.myYanolja

import com.example.rising_test_yanolja.src.main.myYanolja.models.MyYanoljaResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MyYanoljaInterface {
    @GET("/app/my-yanolja")
    fun getMyYanoljaInfo(@Header("x-access-token") params:String) : Call<MyYanoljaResponse>
}