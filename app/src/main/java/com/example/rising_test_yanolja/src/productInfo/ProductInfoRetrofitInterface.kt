package com.example.rising_test_yanolja.src.productInfo

import com.example.rising_test_yanolja.src.productInfo.models.ProductInfoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductInfoRetrofitInterface {
    @GET("/products/rooms")
    fun getRoomInfo(@Query("brandID") brandID : Int, @Query("startDate") startDate : String,
                    @Query("endDate") endDate: String) : Call<ProductInfoResponse>

}