package com.example.rising_test_yanolja.src.main.like.models

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("카테고리") val category : String,
    @SerializedName("숙박업소명") val brandName:String,
    @SerializedName("대표사진") val thumnailImg:String,
    @SerializedName("평균별점") val rating:String,
    @SerializedName("후기갯수") val ratingCount:Int,
    @SerializedName("대실") val halfDayPrice :String,
    @SerializedName("숙박가격") val oneDayPrice:String
)
