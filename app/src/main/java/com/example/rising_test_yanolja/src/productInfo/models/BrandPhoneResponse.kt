package com.example.rising_test_yanolja.src.productInfo.models

import com.example.rising_test_yanolja.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class BrandPhoneResponse(
    @SerializedName("result") val result : List<ResultBrandPhone>
):BaseResponse()
