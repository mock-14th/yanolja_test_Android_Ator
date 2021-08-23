package com.example.rising_test_yanolja.src.productInfo.models

import com.google.gson.annotations.SerializedName

data class result(
    @SerializedName("brandInfo") val brandInfo: List<BrandInfo>,
    @SerializedName("reviewList") val reviewList: List<Review>,
    @SerializedName("roomList") val roomList: List<Room>
)