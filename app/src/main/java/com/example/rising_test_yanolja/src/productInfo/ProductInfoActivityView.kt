package com.example.rising_test_yanolja.src.productInfo

import com.example.rising_test_yanolja.config.BaseResponse
import com.example.rising_test_yanolja.src.productInfo.models.BrandPhoneResponse
import com.example.rising_test_yanolja.src.productInfo.models.ProductInfoResponse

interface ProductInfoActivityView {
    fun onGetProductInfoSuccess(response : ProductInfoResponse)

    fun onGetProductInfoFailure(message : String)

    fun onGetPhoneSuccess(response : BrandPhoneResponse)
    fun onGetPhoneFailure(message:String)


    fun onPostLikeProductSuccess(response : BaseResponse)
    fun onPostLikeProdcutFailure(message:String)
}