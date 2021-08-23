package com.example.rising_test_yanolja.src.productInfo.models

import com.google.gson.annotations.SerializedName

data class Review(
    @SerializedName("내용") val content: String,
    @SerializedName("닉네임") val nickname: String,
    @SerializedName("별점") val rating: String,
    @SerializedName("사용한 방의 옵션") val roomOption: String,
    @SerializedName("사용한방") val useRoom: String,
    @SerializedName("후기쓴날짜") val postscriptDate: String,
    @SerializedName("후기 이미지") val postscriptImg: String
)