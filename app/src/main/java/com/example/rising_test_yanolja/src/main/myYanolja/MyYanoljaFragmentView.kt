package com.example.rising_test_yanolja.src.main.myYanolja

import com.example.rising_test_yanolja.src.main.myYanolja.models.MyYanoljaResponse

interface MyYanoljaFragmentView {

    fun onGetMyYanoljaInfoSuccess(response: MyYanoljaResponse)
    fun onGetMyYanoljaInffoFailure(message:String)

}