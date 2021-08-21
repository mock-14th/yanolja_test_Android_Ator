package com.example.rising_test_yanolja.src.main.area.map

import com.example.rising_test_yanolja.src.main.area.map.models.AreaMapResponse

interface AreaMapFragmentView {

    fun onGetAddressSuccess(response : AreaMapResponse)
    fun onGetAddressFailure(message: String)
}