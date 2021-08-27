package com.example.rising_test_yanolja.src.productInfo

import android.app.Application
import com.example.rising_test_yanolja.config.ApplicationClass
import com.example.rising_test_yanolja.config.BaseResponse
import com.example.rising_test_yanolja.src.productInfo.models.BrandPhoneResponse
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


    fun tryGetBrandPhone(brandID: Int){
        val productInfoRetrofitInterface = ApplicationClass.sRetrofit.create(ProductInfoRetrofitInterface::class.java)
        productInfoRetrofitInterface.getBrandPhone(brandID).enqueue(object:Callback<BrandPhoneResponse>{
            override fun onResponse(call: Call<BrandPhoneResponse>, response: Response<BrandPhoneResponse>) {
                view.onGetPhoneSuccess(response.body() as BrandPhoneResponse)
            }

            override fun onFailure(call: Call<BrandPhoneResponse>, t: Throwable) {
                view.onGetPhoneFailure(t.message ?: "통신 오류")
            }

        })
    }

    fun tryPostLikeProduct(jwt:String,brandID:Int){
        val productInfoRetrofitInterface = ApplicationClass.sRetrofit.create(ProductInfoRetrofitInterface::class.java)
        productInfoRetrofitInterface.postLikeProduct(jwt,brandID).enqueue(object:Callback<BaseResponse>{
            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                view.onPostLikeProductSuccess(response.body() as BaseResponse)
            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                view.onPostLikeProdcutFailure(t.message ?: "통신 실패")
            }

        })
    }
}