package com.example.rising_test_yanolja.src.roomInfo

import com.example.rising_test_yanolja.src.roomInfo.models.RoomInfoResponse
import com.example.rising_test_yanolja.src.roomInfo.models.RoomPhoneNumResponse

interface RoomInfoActivityView {
    fun onGetRoomInfoSuccess(response : RoomInfoResponse)
    fun onGetRoomInfoFailure(message :String)

    fun onGetRoomPhoneNumSuccess(response: RoomPhoneNumResponse)
    fun onGetRoomPhoneNumFailure(message:String)
}