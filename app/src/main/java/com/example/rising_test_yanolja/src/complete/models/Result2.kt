package com.example.rising_test_yanolja.src.complete.models

import com.google.gson.annotations.SerializedName

data class Result2(
    @SerializedName("예약완료되었습니다.") val completeMessage : String,
    @SerializedName("예약일시") val completeTime : String
)
