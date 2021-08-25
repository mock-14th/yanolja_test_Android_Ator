package com.example.rising_test_yanolja.src.roomInfo.models

import com.google.gson.annotations.SerializedName

data class ResultRoomInfo(
    @SerializedName("방타입") var roomType : String,
    @SerializedName("방옵션") var roomOption : String,
    @SerializedName("인원") var personnel : String,
    @SerializedName("숙소명") var brandName : String,
    @SerializedName("방이미지") var roomImage : String,
    @SerializedName("예약정보") var reservationInfo : String,
    @SerializedName("대실") var halfDayPrice : String,
    @SerializedName("숙박가격") var oneDayPrice:String,
    @SerializedName("체크인") var checkIn:String,
    @SerializedName("체크아웃") var checkOut:String
    )
