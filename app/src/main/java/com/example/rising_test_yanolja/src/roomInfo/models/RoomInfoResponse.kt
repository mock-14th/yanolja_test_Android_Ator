package com.example.rising_test_yanolja.src.roomInfo.models

import com.example.rising_test_yanolja.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class RoomInfoResponse(
    @SerializedName("result") var result : List<ResultRoomInfo>
):BaseResponse()
