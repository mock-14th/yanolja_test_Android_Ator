package com.example.rising_test_yanolja.src.main.like

import com.example.rising_test_yanolja.src.main.like.models.LikeProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LikeLoginRetrofitInterface {
    @GET("/app/my-yanolja/liked-list")
    fun getLikeProduct(@Header("x-access-token") jwt:String, @Query("startDate") startDate:String,@Query("endDate") endDate:String,
                       @Query("member") member:Int) : Call<LikeProductResponse>
}