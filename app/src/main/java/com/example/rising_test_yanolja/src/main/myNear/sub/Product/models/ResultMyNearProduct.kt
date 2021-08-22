package com.example.rising_test_yanolja.src.main.myNear.sub.Product.models

import com.google.gson.annotations.SerializedName

data class ResultMyNearProduct(
    @SerializedName("카테고리") val category : String,
    @SerializedName("숙박업소명") val name : String,
    @SerializedName("대표사진") val picture : String,
    @SerializedName("평균별점") val rating : String,
    @SerializedName("후기개수") val review : Int,
    @SerializedName("대실가격") val halfDay : String,
    @SerializedName("숙박가격") val oneDay : String
)
