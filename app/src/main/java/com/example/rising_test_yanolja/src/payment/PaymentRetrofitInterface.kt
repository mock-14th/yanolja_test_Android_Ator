package com.example.rising_test_yanolja.src.payment

import com.example.rising_test_yanolja.src.payment.models.PaymentResponse
import com.example.rising_test_yanolja.src.payment.models.PhoneNumResponse
import com.example.rising_test_yanolja.src.payment.models.PostPaymentRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface PaymentRetrofitInterface {
    @POST("/app/night-booking")
    fun postBookedInfo(@Header("x-access-token") jwt:String ,@Body params :PostPaymentRequest): Call<PaymentResponse>

    @GET("/app/users/phone")
    fun getPhoneNum(@Header("x-access-token") jwt:String) : Call<PhoneNumResponse>
}