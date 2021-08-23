package com.example.rising_test_yanolja.src.productInfo.models

import com.google.gson.annotations.SerializedName

data class BrandInfo(
    @SerializedName("숙박업소명") val name: String,
    @SerializedName("숙소소개") val introduce: String,
    @SerializedName("이용안내") val useInformation: String,
    @SerializedName("전체이미지") val thumnailImg: String,
    @SerializedName("주소") val address: String,
    @SerializedName("카테고리") val category: String,
    @SerializedName("평균별점") val averageRating: String,
    @SerializedName("후기개수") val reviewCount: Int
)