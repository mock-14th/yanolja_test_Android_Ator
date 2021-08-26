package com.example.rising_test_yanolja.src.payment

import com.example.rising_test_yanolja.config.ApplicationClass
import com.example.rising_test_yanolja.src.payment.models.PaymentResponse
import com.example.rising_test_yanolja.src.payment.models.PhoneNumResponse
import com.example.rising_test_yanolja.src.payment.models.PostPaymentRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PaymentService(val view : PaymentActivityView) {

    fun tryPostBookedInfo(jwt:String,postPaymentRequest:PostPaymentRequest){
        val paymentRetrofitInterface = ApplicationClass.sRetrofit.create(PaymentRetrofitInterface::class.java)
        paymentRetrofitInterface.postBookedInfo(jwt,postPaymentRequest).enqueue(object : Callback<PaymentResponse> {
            override fun onResponse(call: Call<PaymentResponse>, response: Response<PaymentResponse>) {
                view.onPostBookedInfoSuccess(response.body() as PaymentResponse)
            }

            override fun onFailure(call: Call<PaymentResponse>, t: Throwable) {
                view.onPostBookInfoFailure(t.message ?: "통신 오류")
            }
        })
    }

    fun tryGetPhoneNum(jwt:String){
        val paymentRetrofitInterface = ApplicationClass.sRetrofit.create(PaymentRetrofitInterface::class.java)
        paymentRetrofitInterface.getPhoneNum(jwt).enqueue(object:Callback<PhoneNumResponse>{
            override fun onResponse(call: Call<PhoneNumResponse>, response: Response<PhoneNumResponse>) {
                view.onGetPhoneNumSuccess(response.body() as PhoneNumResponse)
            }

            override fun onFailure(call: Call<PhoneNumResponse>, t: Throwable) {
                view.onGetPhoneNumFailure(t.message ?: "통신 오류")
            }

        })
    }
}