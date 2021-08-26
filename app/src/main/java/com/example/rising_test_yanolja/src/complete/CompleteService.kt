package com.example.rising_test_yanolja.src.complete

import com.example.rising_test_yanolja.config.ApplicationClass
import com.example.rising_test_yanolja.src.complete.models.CompleteResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CompleteService(val view : CompleteActivityView) {
    fun tryOnPostPayInfo(jwt:String,bookedNum:Int,point:Int){
        val completeRetrofitInterface = ApplicationClass.sRetrofit.create(CompleteRetrofitInterface::class.java)
        completeRetrofitInterface.postPayInfo(jwt,bookedNum,point).enqueue(object:Callback<CompleteResponse>{
            override fun onResponse(call: Call<CompleteResponse>, response: Response<CompleteResponse>) {
                view.onPostPayInfoSuccess(response.body() as CompleteResponse)
            }

            override fun onFailure(call: Call<CompleteResponse>, t: Throwable) {
                view.onPostPayInfoFailure(t.message ?: "통신 오류")
            }

        })
    }
}