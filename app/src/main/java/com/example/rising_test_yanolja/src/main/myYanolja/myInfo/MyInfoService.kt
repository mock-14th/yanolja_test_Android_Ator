package com.example.rising_test_yanolja.src.main.myYanolja.myInfo

import com.example.rising_test_yanolja.config.ApplicationClass
import com.example.rising_test_yanolja.config.BaseResponse
import com.example.rising_test_yanolja.src.main.myYanolja.myInfo.models.MyInfoResponse
import com.example.rising_test_yanolja.src.main.myYanolja.myInfo.models.PostChangeUserRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyInfoService (val view : MyInfoActivityView){
    fun tryGetUserEmailPhone(jwt:String){
        val myInfoRetrofitInterface = ApplicationClass.sRetrofit.create(MyInfoRetrofitInterface::class.java)
        myInfoRetrofitInterface.getUserEmailPhone(jwt).enqueue(object: Callback<MyInfoResponse>{
            override fun onResponse(call: Call<MyInfoResponse>, response: Response<MyInfoResponse>) {
                view.onGetUserEmailPhoneSuccess(response.body() as MyInfoResponse)
            }

            override fun onFailure(call: Call<MyInfoResponse>, t: Throwable) {
                view.onGetUserEmailPhoneFailure(t.message ?: "통신 오류")
            }

        })
    }

    fun tryPostChangeUser(jwt:String,postChangeUserRequest: PostChangeUserRequest){
        var myInfoRetrofitInterface = ApplicationClass.sRetrofit.create(MyInfoRetrofitInterface::class.java)
        myInfoRetrofitInterface.postChangeUser(jwt,postChangeUserRequest).enqueue(object:Callback<BaseResponse>{
            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                view.onPostChangeUserNicknameSuccess(response.body() as BaseResponse)
            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                view.onPostChangeUserNicknameFailure(t.message ?: "통신 오류")
            }

        })
    }
}