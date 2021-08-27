package com.example.rising_test_yanolja.src.main.like

import com.example.rising_test_yanolja.config.ApplicationClass
import com.example.rising_test_yanolja.src.main.like.models.LikeProductResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LikeLoginService(val view : LikeLoginFragmentView) {
    fun tryGetLikeProduct(jwt:String,startDate:String,endDate:String,member:Int){
        val likeLoginFragmentRetrofitInterface = ApplicationClass.sRetrofit.create(LikeLoginRetrofitInterface::class.java)
        likeLoginFragmentRetrofitInterface.getLikeProduct(jwt,startDate,endDate,member).enqueue(object : Callback<LikeProductResponse>{
            override fun onResponse(call: Call<LikeProductResponse>, response: Response<LikeProductResponse>) {
                view.onGetLikeProductSuccess(response.body() as LikeProductResponse)
            }

            override fun onFailure(call: Call<LikeProductResponse>, t: Throwable) {
                view.onGetLikeProductFailure(t.message ?: "통신 오류")
            }

        })
    }
}