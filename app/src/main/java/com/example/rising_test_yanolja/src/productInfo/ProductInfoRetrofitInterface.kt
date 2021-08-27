package com.example.rising_test_yanolja.src.productInfo

import com.example.rising_test_yanolja.config.BaseResponse
import com.example.rising_test_yanolja.src.productInfo.models.BrandPhoneResponse
import com.example.rising_test_yanolja.src.productInfo.models.ProductInfoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface ProductInfoRetrofitInterface {
    @GET("/products/rooms")
    fun getRoomInfo(@Query("brandID") brandID : Int, @Query("startDate") startDate : String,
                    @Query("endDate") endDate: String) : Call<ProductInfoResponse>

    @GET("/products/brand/call")
    fun getBrandPhone(@Query("brandID") brandID:Int) :Call<BrandPhoneResponse>

    @POST("/app/into-liked")
    fun postLikeProduct(@Header("x-access-token") jwt:String,@Query("brandID") brandID: Int) : Call<BaseResponse>

}