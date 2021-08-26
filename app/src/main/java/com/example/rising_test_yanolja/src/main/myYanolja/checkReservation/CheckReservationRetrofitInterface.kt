package com.example.rising_test_yanolja.src.main.myYanolja.checkReservation

import com.example.rising_test_yanolja.src.main.myYanolja.checkReservation.models.CheckReservationResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CheckReservationRetrofitInterface {
    @GET("/app/booking/info")
    fun getReservation(@Header("x-access-token") jwt:String,@Query("bookedNum") bookedNum:Int) : Call<CheckReservationResponse>
}