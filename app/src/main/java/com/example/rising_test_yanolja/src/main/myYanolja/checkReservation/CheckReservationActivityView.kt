package com.example.rising_test_yanolja.src.main.myYanolja.checkReservation

import com.example.rising_test_yanolja.src.main.myYanolja.checkReservation.models.CheckReservationResponse

interface CheckReservationActivityView {
    fun onGetReservationSuccess(response : CheckReservationResponse)
    fun onGetReservationFailure(message:String)
}