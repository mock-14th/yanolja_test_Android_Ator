package com.example.rising_test_yanolja.src.complete

import com.example.rising_test_yanolja.src.complete.models.CompleteResponse
import retrofit2.Call
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface CompleteRetrofitInterface {
    @POST("/app/booking/payment")
    fun postPayInfo(@Header("x-access-token") jwt:String, @Query("bookedNum") bookedNum:Int, @Query("point") point:Int) : Call<CompleteResponse>
}