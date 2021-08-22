package com.example.rising_test_yanolja.src.main.myNear.sub.Product

import com.example.rising_test_yanolja.src.main.myNear.sub.Product.models.MyNearSubProductResponse

interface MyNearSubProductFragmentView {
    fun onGetMotelsListSuccess(response : MyNearSubProductResponse)

    fun onGetMotelsListFailure(message: String)
}