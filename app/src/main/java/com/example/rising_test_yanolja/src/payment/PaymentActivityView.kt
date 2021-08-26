package com.example.rising_test_yanolja.src.payment

import com.example.rising_test_yanolja.src.payment.models.PaymentResponse
import com.example.rising_test_yanolja.src.payment.models.PhoneNumResponse

interface PaymentActivityView {
    fun onPostBookedInfoSuccess(response:PaymentResponse)
    fun onPostBookInfoFailure(message:String)
    fun onGetPhoneNumSuccess(response:PhoneNumResponse)
    fun onGetPhoneNumFailure(message:String)
}