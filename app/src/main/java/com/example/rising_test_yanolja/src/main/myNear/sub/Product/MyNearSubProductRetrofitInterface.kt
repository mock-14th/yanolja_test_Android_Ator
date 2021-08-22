package com.example.rising_test_yanolja.src.main.myNear.sub.Product

import com.example.rising_test_yanolja.src.main.myNear.sub.Product.models.MyNearSubProductResponse
import retrofit2.Call
import retrofit2.http.GET

interface MyNearSubProductRetrofitInterface {
    @GET("/products/motels")
    fun getMotelsList() : Call<MyNearSubProductResponse>
}