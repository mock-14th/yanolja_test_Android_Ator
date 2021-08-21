package com.example.rising_test_yanolja.src.main.area.map

import com.example.rising_test_yanolja.src.main.area.map.models.AreaMapResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface AreaMapRetrofitInterface {
    @GET("gc")
    fun getAddress(@Header("X-NCP-APIGW-API-KEY-ID") params:String,@Header("X-NCP-APIGW-API-KEY") key :String
                   ,@Query("coords") coords  :String,@Query("output") output:String) : Call<AreaMapResponse>

}