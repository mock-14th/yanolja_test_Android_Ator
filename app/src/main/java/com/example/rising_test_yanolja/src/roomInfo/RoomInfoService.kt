package com.example.rising_test_yanolja.src.roomInfo

import com.example.rising_test_yanolja.config.ApplicationClass
import com.example.rising_test_yanolja.src.roomInfo.models.RoomInfoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RoomInfoService(val view : RoomInfoActivityView) {
    fun tryGetRoomInfo(startDate:String,endDate:String,roomType:String,brandID:Int){
        val roomInfoRetrofitInfoInterface = ApplicationClass.sRetrofit.create(RoomInfoRetrofitInterface::class.java)
        roomInfoRetrofitInfoInterface.getRoomInfo(startDate,endDate,roomType,brandID).enqueue(object : Callback<RoomInfoResponse>{
            override fun onResponse(call: Call<RoomInfoResponse>, response: Response<RoomInfoResponse>) {
                view.onGetRoomInfoSuccess(response.body() as RoomInfoResponse)
            }

            override fun onFailure(call: Call<RoomInfoResponse>, t: Throwable) {
                view.onGetRoomInfoFailure(t.message ?:"통신 오류")
            }

        })
    }
}