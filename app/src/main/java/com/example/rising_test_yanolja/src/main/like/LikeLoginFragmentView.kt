package com.example.rising_test_yanolja.src.main.like

import com.example.rising_test_yanolja.src.main.like.models.LikeProductResponse

interface LikeLoginFragmentView {
    fun onGetLikeProductSuccess(response : LikeProductResponse)
    fun onGetLikeProductFailure(message:String)
}