package com.example.rising_test_yanolja.src.main.myYanolja.checkReservation.models

import com.example.rising_test_yanolja.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class CheckReservationResponse(
    @SerializedName("result") val result : Result
):BaseResponse()
