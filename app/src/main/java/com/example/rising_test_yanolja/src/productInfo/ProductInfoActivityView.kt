package com.example.rising_test_yanolja.src.productInfo

import com.example.rising_test_yanolja.src.productInfo.models.ProductInfoResponse

interface ProductInfoActivityView {
    fun onGetProductInfoSuccess(response : ProductInfoResponse)

    fun onGetProductInfoFailure(message : String)
}