package com.example.rising_test_yanolja.src.signUp

import android.content.Intent
import android.os.Bundle
import com.example.rising_test_yanolja.config.BaseActivity
import com.example.rising_test_yanolja.databinding.ActivityCompleteSignUpBinding
import com.example.rising_test_yanolja.src.main.MainActivity

class CompleteSignUpActivity : BaseActivity<ActivityCompleteSignUpBinding>(ActivityCompleteSignUpBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.completeSignUpBtnOk.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            intent.putExtra("currentViewPagerIndex",4)
            startActivity(intent)
        }

    }
}