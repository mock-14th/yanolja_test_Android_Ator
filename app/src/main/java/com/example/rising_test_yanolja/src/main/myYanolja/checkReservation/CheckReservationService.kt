package com.example.rising_test_yanolja.src.main.myYanolja.checkReservation

import com.example.rising_test_yanolja.config.ApplicationClass
import com.example.rising_test_yanolja.src.main.myYanolja.checkReservation.models.CheckReservationResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CheckReservationService(val view : CheckReservationActivityView) {
    fun tryGetReservation(jwt:String,bookedNum:Int){
        val checkReservationRetrofitInterface = ApplicationClass.sRetrofit.create(CheckReservationRetrofitInterface::class.java)
        checkReservationRetrofitInterface.getReservation(jwt,bookedNum).enqueue(object: Callback<CheckReservationResponse>{
            override fun onResponse(call: Call<CheckReservationResponse>, response: Response<CheckReservationResponse>) {
                view.onGetReservationSuccess(response.body() as CheckReservationResponse)
            }

            override fun onFailure(call: Call<CheckReservationResponse>, t: Throwable) {
                view.onGetReservationFailure(t.message ?: "통신 오류")
            }

        })
    }
}