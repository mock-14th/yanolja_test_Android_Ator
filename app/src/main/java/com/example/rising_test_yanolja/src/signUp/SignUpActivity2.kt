package com.example.rising_test_yanolja.src.signUp

import android.os.Bundle
import android.os.CountDownTimer
import android.telephony.PhoneNumberFormattingTextWatcher
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.example.rising_test_yanolja.config.BaseActivity
import com.example.rising_test_yanolja.databinding.ActivitySignUp2Binding

class SignUpActivity2 : BaseActivity<ActivitySignUp2Binding>(ActivitySignUp2Binding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //edt phone 텍스트 체인지 리스터
        binding.signUpEdtPhone.addTextChangedListener(object : PhoneNumberFormattingTextWatcher() {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                super.onTextChanged(s, start, before, count)
                var inputPhone = binding.signUpEdtPhone.text.toString()
                binding.signUp2IdImgOk.visibility = View.INVISIBLE

                if (!inputPhone.isEmpty())
                    binding.signUp2BtnIdReset.visibility = View.VISIBLE
                else
                    binding.signUp2BtnIdReset.visibility = View.INVISIBLE

                if (inputPhone.length > 12)
                    binding.signUp2BtnSend.isEnabled = true
            }
        })


        //타이머 구현할 코드
        object : CountDownTimer(3000, 1000) {
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
            }
        }


        //edt phone 포커싱 리스너너
        binding.signUpEdtPhone.setOnFocusChangeListener { v, hasFocus ->
            var inputPhone = binding.signUpEdtPhone.text.toString()

            if (hasFocus) {
                binding.signUp2IdImgOk.visibility = View.INVISIBLE
                if (!inputPhone.isEmpty())
                        binding.signUp2BtnIdReset.visibility = View.VISIBLE
            } else {
                binding.signUp2BtnIdReset.visibility = View.INVISIBLE
            }



            //인증번호 전송 버튼 클릭 리스너
            binding.signUp2BtnSend.setOnClickListener {
                binding.signUp2BtnSend.visibility = View.INVISIBLE
                binding.signUp2BtnResend.visibility = View.VISIBLE
                binding.signUp2IdImgOk.visibility = View.VISIBLE
                binding.signUp2BtnIdReset.visibility = View.INVISIBLE
                binding.signUp2TextInputLayoutVertification.visibility = View.VISIBLE
            }

        }
    }
}
