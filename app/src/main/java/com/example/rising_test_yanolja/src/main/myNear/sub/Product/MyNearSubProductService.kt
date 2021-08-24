package com.example.rising_test_yanolja.src.main.myNear.sub.Product

import com.example.rising_test_yanolja.config.ApplicationClass
import com.example.rising_test_yanolja.src.main.myNear.sub.Product.models.MyNearSubProductResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyNearSubProductService(val view:MyNearSubProductFragmentView) {

    fun tryGetMotelsList(){
        val myNearSubProductRetrofitInterface = ApplicationClass.sRetrofit.create(MyNearSubProductRetrofitInterface::class.java)
        myNearSubProductRetrofitInterface.getMotelsList(1,"2021-08-18","2021-08-20",1).enqueue(object: Callback<MyNearSubProductResponse>{
            override fun onFailure(call: Call<MyNearSubProductResponse>, t: Throwable) {
                view.onGetMotelsListFailure(t.message ?: "통신 오류")
            }

            override fun onResponse(call: Call<MyNearSubProductResponse>, response: Response<MyNearSubProductResponse>) {
                view.onGetMotelsListSuccess(response.body() as MyNearSubProductResponse)
            }

        })
    }
}