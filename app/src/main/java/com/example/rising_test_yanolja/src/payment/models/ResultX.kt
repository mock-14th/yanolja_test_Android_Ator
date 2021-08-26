package com.example.rising_test_yanolja.src.payment.models

data class ResultX(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)