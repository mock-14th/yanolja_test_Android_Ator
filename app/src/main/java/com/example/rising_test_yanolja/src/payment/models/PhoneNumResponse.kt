package com.example.rising_test_yanolja.src.payment.models

import com.example.rising_test_yanolja.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class PhoneNumResponse(
    @SerializedName("result") val result:List<ResultPhoneNum>
):BaseResponse()
