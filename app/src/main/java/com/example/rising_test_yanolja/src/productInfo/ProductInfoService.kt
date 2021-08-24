package com.example.rising_test_yanolja.src.productInfo

import android.app.Application
import com.example.rising_test_yanolja.config.ApplicationClass
import com.example.rising_test_yanolja.src.productInfo.models.ProductInfoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductInfoService(val view : ProductInfoActivityView) {
    fun tryGetProductInfo(brandID:Int,startDate:String,endDate:String){
        val productInfoRetrofitInterface = ApplicationClass.sRetrofit.create(ProductInfoRetrofitInterface::class.java)
        productInfoRetrofitInterface.getRoomInfo(brandID,startDate,endDate).enqueue(object :
            Callback<ProductInfoResponse>{
            override fun onResponse(
                call: Call<ProductInfoResponse>,
                response: Response<ProductInfoResponse>
            ) {
                view.onGetProductInfoSuccess(response.body() as ProductInfoResponse)
            }
            override fun onFailure(call: Call<ProductInfoResponse>, t: Throwable) {
                view.onGetProductInfoFailure(t.message ?: "통신 오류")
            }

        })

    }
}