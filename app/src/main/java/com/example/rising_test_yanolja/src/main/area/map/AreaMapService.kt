package com.example.rising_test_yanolja.src.main.area.map

import com.example.rising_test_yanolja.config.ApplicationClass
import com.example.rising_test_yanolja.config.ApplicationClass.NAVER_MAP_API.CLIENT_SECRET
import com.example.rising_test_yanolja.config.ApplicationClass.NAVER_MAP_API.CLINET_ID
import com.example.rising_test_yanolja.src.main.area.map.models.AreaMapResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AreaMapService(val view:AreaMapFragmentView) {

    fun tryGetAddress(coords:String){
        val homeRetrofitInterface = ApplicationClass.mapRetrofit.create(AreaMapRetrofitInterface::class.java)
        homeRetrofitInterface.getAddress(CLINET_ID,CLIENT_SECRET,coords,"json").enqueue(object:Callback<AreaMapResponse>{
            override fun onResponse(call: Call<AreaMapResponse>, response: Response<AreaMapResponse>) {
                view.onGetAddressSuccess(response.body() as AreaMapResponse)
            }

            override fun onFailure(call: Call<AreaMapResponse>, t: Throwable) {
                view.onGetAddressFailure(t.message ?: "통신 오류")
            }
        })
    }
}