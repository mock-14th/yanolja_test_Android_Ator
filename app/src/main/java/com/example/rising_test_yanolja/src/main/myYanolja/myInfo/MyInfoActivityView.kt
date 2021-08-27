package com.example.rising_test_yanolja.src.main.myYanolja.myInfo

import com.example.rising_test_yanolja.config.BaseResponse
import com.example.rising_test_yanolja.src.main.myYanolja.myInfo.models.MyInfoResponse

interface MyInfoActivityView {
    fun onGetUserEmailPhoneSuccess(response: MyInfoResponse)
    fun onGetUserEmailPhoneFailure(message:String)
    fun onPostChangeUserNicknameSuccess(response: BaseResponse)
    fun onPostChangeUserNicknameFailure(message:String)
}