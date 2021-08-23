package com.example.rising_test_yanolja.src.productInfo.models

import com.google.gson.annotations.SerializedName

data class Room(
    @SerializedName("brandName") val brandName: String,
    @SerializedName("roomID") val roomID: Int,
    @SerializedName("기준인원") val basePersonnel: Int,
    @SerializedName("대실") val halfDayPrice: String,
    @SerializedName("방 대표 이미지") val roomImg: String,
    @SerializedName("방옵션") val roomOption: String,
    @SerializedName("방타입") val roomType: String,
    @SerializedName("숙박가격") val oneDayPrice: String,
    @SerializedName("체크인시간") val checkInTime: String,
    @SerializedName("최대인원") val totalPersonnel: Int
)