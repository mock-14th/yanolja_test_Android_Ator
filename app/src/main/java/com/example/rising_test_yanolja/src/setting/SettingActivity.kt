package com.example.rising_test_yanolja.src.setting

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.TextView
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.ApplicationClass
import com.example.rising_test_yanolja.config.BaseActivity
import com.example.rising_test_yanolja.databinding.ActivitySettingBinding
import com.example.rising_test_yanolja.src.main.MainActivity

class SettingActivity : BaseActivity<ActivitySettingBinding>(ActivitySettingBinding::inflate) {
    private lateinit var JWT : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        JWT = ApplicationClass.sSharedPreferences.getString("X_ACCESS_TOKEN","").toString()

        if (JWT.isEmpty()){
            binding.settingBtnSimpleLogin.visibility=View.GONE
            binding.settingBtnLogOut.visibility=View.GONE
            binding.line2.visibility=View.GONE
            binding.line6.visibility=View.GONE
        }

        var dialog_logout = Dialog(this)
        dialog_logout.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog_logout.setContentView(R.layout.dialog_setting_log_out)
        dialog_logout.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        binding.settingBtnLogOut.setOnClickListener {
            dialog_logout.show()

            var btn_positive = dialog_logout.findViewById<TextView>(R.id.dialog_setting_log_out_btn_postive)
            var btn_negative = dialog_logout.findViewById<TextView>(R.id.dialog_setting_log_out_btn_negative)

            btn_negative.setOnClickListener {  }
            btn_positive.setOnClickListener {
                var editor = ApplicationClass.sSharedPreferences.edit()
                editor.putString("X_ACCESS_TOKEN","")
                editor.apply()

                var intent = Intent(this,MainActivity::class.java)
                intent.putExtra("currentViewPagerIndex",4)
                startActivity(intent)
                finish()
            }

        }

    }
}