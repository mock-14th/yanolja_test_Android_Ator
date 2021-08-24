package com.example.rising_test_yanolja.src.main.myNear.sub.Product

import com.example.rising_test_yanolja.src.main.myNear.sub.Product.models.MyNearSubProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MyNearSubProductRetrofitInterface {
    @GET("/products/motels")
    fun getMotelsList(@Query("region") region: Int, @Query("startDate") startDate : String,
                      @Query("endDate") endDate : String ,
                      @Query("member") member:Int) : Call<MyNearSubProductResponse>
}