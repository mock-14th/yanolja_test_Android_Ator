package com.example.rising_test_yanolja.src.main.myYanolja

import android.util.Log
import com.example.rising_test_yanolja.config.ApplicationClass
import com.example.rising_test_yanolja.src.main.myYanolja.models.MyYanoljaResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyYanoljaService(val view: MyYanoljaFragmentView) {

    fun tryGetMyYanoljaInfo(jwt:String){
        val myYanoljaInterface = ApplicationClass.sRetrofit.create(MyYanoljaInterface::class.java)
        myYanoljaInterface.getMyYanoljaInfo(jwt).enqueue(object:Callback<MyYanoljaResponse>{
            override fun onResponse(call: Call<MyYanoljaResponse>, response: Response<MyYanoljaResponse>) {
                view.onGetMyYanoljaInfoSuccess(response.body() as MyYanoljaResponse)

            }

            override fun onFailure(call: Call<MyYanoljaResponse>, t: Throwable) {
                view.onGetMyYanoljaInffoFailure(t.message ?: "통신 오류")
            }
        })
    }
}