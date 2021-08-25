package com.example.rising_test_yanolja.src.roomInfo

import com.example.rising_test_yanolja.src.roomInfo.models.RoomInfoResponse
import com.example.rising_test_yanolja.src.roomInfo.models.RoomPhoneNumResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RoomInfoRetrofitInterface {
    @GET("/products/rooms/room-detail")
    fun getRoomInfo(@Query("startDate") startDate:String,
                    @Query("endDate") endDate : String,
                    @Query("roomType") roomType:String,
                    @Query("brandID") brandID:Int) : Call<RoomInfoResponse>

    @GET("/products/rooms/room-detail")
    fun getRoomPhoneNum(@Query("brandID") brandID: String) : Call<RoomPhoneNumResponse>
}