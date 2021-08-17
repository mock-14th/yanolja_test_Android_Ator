package com.example.rising_test_yanolja.src.login

import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.text.method.SingleLineTransformationMethod
import android.view.View
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.databinding.ActivityLoginBinding
import com.softsquared.template.kotlin.config.BaseActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate){
    private var isIdInput = false
    private var isPwdInput = false
    private var isPwdToggle = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //IdEdtText에 입력이 되었는지 확인하는 코드
        binding.loginEdtId.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(binding.loginEdtId.length()!=0){
                    isIdInput=true
                    if(isIdInput&&isPwdInput){
                        binding.loginBtnLogin.isEnabled=true
                    }
                }else{
                    isIdInput=false
                    binding.loginBtnLogin.isEnabled=false
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })

        //PasswordEdtText에 입력이 되었는지 확인하는 코드
        binding.loginEdtPwd.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(binding.loginEdtPwd.length()!=0){
                    isPwdInput=true
                    binding.loginBtnPasswdToggle.visibility= View.VISIBLE
                    if(isIdInput&&isPwdInput){
                        binding.loginBtnLogin.isEnabled=true
                    }
                }else{
                    isPwdInput=false
                    binding.loginBtnPasswdToggle.visibility= View.INVISIBLE
                    binding.loginBtnLogin.isEnabled=false
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })


        //passwd toggle 버튼 동작 메소드드
       binding.loginBtnPasswdToggle.setOnClickListener {
            if(!isPwdToggle){
                isPwdToggle=true
                binding.loginBtnPasswdToggle.setImageResource(R.drawable.close_eye_img)
                binding.loginEdtPwd.transformationMethod = SingleLineTransformationMethod.getInstance()
                //binding.loginEdtPwd.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                binding.loginEdtPwd.setSelection(binding.loginEdtPwd.length())
            }else{
                isPwdToggle=false
                binding.loginBtnPasswdToggle.setImageResource(R.drawable.open_eye_img)
                binding.loginEdtPwd.transformationMethod = PasswordTransformationMethod.getInstance()
                //binding.loginEdtPwd.inputType = (InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
                binding.loginEdtPwd.setSelection(binding.loginEdtPwd.length())
            }
        }

    }
}