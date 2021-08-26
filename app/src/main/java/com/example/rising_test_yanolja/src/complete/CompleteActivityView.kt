package com.example.rising_test_yanolja.src.complete

import com.example.rising_test_yanolja.src.complete.models.CompleteResponse

interface CompleteActivityView {
    fun onPostPayInfoSuccess(response:CompleteResponse)
    fun onPostPayInfoFailure(message:String)
}