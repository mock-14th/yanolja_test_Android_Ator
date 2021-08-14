package com.example.rising_test_yanolja.src.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.rising_test_yanolja.databinding.ActivitySplashBinding
import com.example.rising_test_yanolja.src.main.MainActivity
import com.softsquared.template.kotlin.config.BaseActivity

class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 1500)
    }
}