package com.example.rising_test_yanolja.src.signUp

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.text.method.SingleLineTransformationMethod
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.widget.addTextChangedListener
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.BaseActivity
import com.example.rising_test_yanolja.databinding.ActivitySignUp1Binding
import java.util.regex.Matcher
import java.util.regex.Pattern

class SignUpActivity1 : BaseActivity<ActivitySignUp1Binding>(ActivitySignUp1Binding::inflate) {


    private var isWronPwd = false
    private var isPwdToggle = false
    private var isPwdCheckToggle = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //회원가입 activity 들어오면 edt id로 강제 포커싱을 준다.
        binding.signUpEdtId.post(Runnable {
            binding.signUpEdtId.setFocusableInTouchMode(true)
            binding.signUpEdtId.requestFocus()
            val imm: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(binding.signUpEdtId, 0)
        })



        //x버튼 누르면 activity 종료하기
        binding.signUpBtnBack.setOnClickListener {
            finish()
        }


        //edtId 포커싱 리스너
        binding.signUpEdtId.setOnFocusChangeListener { v, hasFocus ->
            var inputId = binding.signUpEdtId.text.toString()
            if (hasFocus){
                binding.signUpIdImgOk.visibility=View.INVISIBLE
                if(!inputId.isEmpty())
                    binding.signUpBtnIdReset.visibility=View.VISIBLE
            }else{
                binding.signUpBtnIdReset.visibility=View.INVISIBLE
                if(!inputId.isEmpty())
                    binding.signUpIdImgOk.visibility=View.VISIBLE
            }
        }

        //edtId 텍스트 체인지 리스너
        binding.signUpEdtId.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var inputId = binding.signUpEdtId.text.toString()
                if(!inputId.isEmpty())
                    binding.signUpBtnIdReset.visibility=View.VISIBLE
                else
                    binding.signUpBtnIdReset.visibility=View.INVISIBLE


                //입력 받는 값이 email형식인지 확인하고 맞으면 다음 버튼 활성화
                binding.signUpBtnNext.isEnabled = isEmailValid(inputId)

            }

            override fun afterTextChanged(s: Editable?) {
            }
        })





        //edtId reset btn 클릭 리스너
        binding.signUpBtnIdReset.setOnClickListener {
            binding.signUpEdtId.text=null
        }


        //다음 버튼 클릭 리스너
        binding.signUpBtnNext.setOnClickListener {
            binding.signUpTextInputLayoutPwd.visibility=View.VISIBLE
            binding.signUpTextInputLayoutPwdCheck.visibility=View.VISIBLE
            binding.signUpBtnOk.visibility=View.VISIBLE
            binding.signUpBtnNext.visibility=View.INVISIBLE


            //다음 버튼 누르면 edt pwd로 강제 포커싱을 준다.
            binding.signUpEdtPwd.post(Runnable {
                binding.signUpEdtPwd.setFocusableInTouchMode(true)
                binding.signUpEdtPwd.requestFocus()
                val imm: InputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(binding.signUpEdtPwd, 0)
            })

        }



        //edtPasswd 포커싱 리스너
        binding.signUpEdtPwd.setOnFocusChangeListener { v, hasFocus ->
            var inputPwd = binding.signUpEdtPwd.text.toString() //사용자 입력 저장

            if (hasFocus) { //포커싱 받을 때
                binding.signUpImgPasswdOk.visibility=View.INVISIBLE
                if (isWronPwd==false){
                    binding.signUpTxGuide.visibility = View.VISIBLE
                }
                if (!inputPwd.isEmpty()) //포커싱 받을 때 edt passwd가 비어있지 않으면 토글 버튼 보이게
                    binding.signUpBtnPasswdToggle.visibility=View.VISIBLE
            } else { //포커싱 없어질 때
                binding.signUpBtnPasswdToggle.visibility=View.INVISIBLE

                var passwrod_pattern =
                    "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$" //숫자 1개라도 포함, 영어 1개라도 포함, 특수문자 1개라도 포함해서 8~20사이

                if (!Pattern.matches(passwrod_pattern, inputPwd)){  //사용자 입력값과 패턴의 일치를 묻기
                    if (!inputPwd.isEmpty()){
                        isWronPwd=true
                        binding.signUpTextInputLayoutPwd.error=" "
                        binding.signUpTxWrongGuide.visibility=View.VISIBLE //틀렸을 경우 가이드 라인 보이게
                        binding.signUpTxGuide.visibility = View.INVISIBLE //일반 가이드라인 안보이게
                        binding.signUpImgPasswdOk.visibility=View.INVISIBLE
                    }
                }else{
                    binding.signUpImgPasswdOk.visibility=View.VISIBLE
                }
                    binding.signUpTxGuide.visibility = View.INVISIBLE

            }
        }


        //edt pwd의 텍스트 체인지 리스너
        binding.signUpEdtPwd.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var inputPwdCheck = binding.signUpEdtPwdCheck.text.toString()
                isWronPwd=false
                binding.signUpTextInputLayoutPwd.error=null
                binding.signUpTxWrongGuide.visibility=View.INVISIBLE
                binding.signUpTxGuide.visibility = View.VISIBLE


                if (binding.signUpEdtPwd.length() != 0) {
                    if(binding.signUpEdtPwd.text.toString().equals(inputPwdCheck) && !inputPwdCheck.isEmpty()){
                        binding.signUpImgPasswdOk.visibility=View.VISIBLE
                        binding.signUpBtnPasswdToggle.visibility=View.INVISIBLE

                        binding.signUpTextInputLayoutPwdCheck.error=null
                        binding.signUpTxDifferentGuide.visibility=View.INVISIBLE
                        binding.signUpImgPasswdCheckOk.visibility=View.VISIBLE


                    }else{
                        binding.signUpBtnPasswdToggle.visibility = View.VISIBLE
                    }
                } else {
                    binding.signUpBtnPasswdToggle.visibility = View.INVISIBLE
                }


                if(!binding.signUpEdtPwd.text.toString().equals(inputPwdCheck) && !inputPwdCheck.isEmpty()) { //edtPwd와 edtPwdCheck의 입력값이 틀리면 확인 버튼 비활성화
                    binding.signUpTextInputLayoutPwdCheck.error = " "
                    binding.signUpTxDifferentGuide.visibility = View.VISIBLE
                    binding.signUpBtnOk.isEnabled = false
                    binding.signUpImgPasswdCheckOk.visibility=View.INVISIBLE
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })



        //edt pwdCheck의 텍스트 체인지 리스너
        binding.signUpEdtPwdCheck.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var inputPwdCheck = binding.signUpEdtPwdCheck.text.toString()

                if(!binding.signUpEdtPwd.text.toString().equals(inputPwdCheck) && !inputPwdCheck.isEmpty()){ //edtPwd와 edtPwdCheck의 입력값이 틀리면 확인 버튼 비활성화
                    binding.signUpTextInputLayoutPwdCheck.error=" "
                    binding.signUpTxDifferentGuide.visibility=View.VISIBLE
                    binding.signUpBtnOk.isEnabled=false
                    binding.signUpImgPasswdCheckOk.visibility=View.INVISIBLE


                }else{ //edtPwd와 edtPwdCheck의 입력값이 같으면 확인 버튼 활성화
                    binding.signUpTextInputLayoutPwdCheck.error=null
                    binding.signUpTxDifferentGuide.visibility=View.INVISIBLE
                    if(binding.signUpEdtPwd.text.toString().equals(inputPwdCheck) && !isWronPwd)
                        binding.signUpBtnOk.isEnabled=true
                }

                if (binding.signUpEdtPwd.length() != 0) {
                    if(binding.signUpEdtPwd.text.toString().equals(inputPwdCheck) && !inputPwdCheck.isEmpty()){
                        binding.signUpImgPasswdCheckOk.visibility=View.VISIBLE
                        binding.signUpBtnPasswdCheckToggle.visibility=View.INVISIBLE

                    }else{
                        binding.signUpBtnPasswdCheckToggle.visibility = View.VISIBLE
                    }

                } else {
                    binding.signUpBtnPasswdCheckToggle.visibility = View.INVISIBLE
                }





            }

            override fun afterTextChanged(s: Editable?) {
            }
        })


        //edt pwdCheck의 포커싱 리스너
        binding.signUpEdtPwdCheck.setOnFocusChangeListener { v, hasFocus ->
            var inputPwdCheck = binding.signUpEdtPwdCheck.text.toString()

            if(hasFocus){
                binding.signUpImgPasswdCheckOk.visibility=View.INVISIBLE

                if(binding.signUpEdtPwd.text.toString().equals(inputPwdCheck)){
                    if(!inputPwdCheck.isEmpty()){
                        binding.signUpTxDifferentGuide.visibility=View.INVISIBLE
                        binding.signUpTextInputLayoutPwdCheck.error=null
                    }
                }

                if (!inputPwdCheck.isEmpty())
                    binding.signUpBtnPasswdCheckToggle.visibility=View.VISIBLE

            }else{
                binding.signUpBtnPasswdCheckToggle.visibility=View.INVISIBLE
                if (binding.signUpBtnOk.isEnabled)
                    binding.signUpImgPasswdCheckOk.visibility=View.VISIBLE

            }
        }




        //passwd toggle 버튼 동작 메소드드
        binding.signUpBtnPasswdToggle.setOnClickListener {
            if (!isPwdToggle) {
                isPwdToggle = true
                binding.signUpBtnPasswdToggle.setImageResource(R.drawable.close_eye_img)
                binding.signUpEdtPwd.transformationMethod =
                    SingleLineTransformationMethod.getInstance()
                //binding.loginEdtPwd.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                binding.signUpEdtPwd.setSelection(binding.signUpEdtPwd.length())
            } else {
                isPwdToggle = false
                binding.signUpBtnPasswdToggle.setImageResource(R.drawable.open_eye_img)
                binding.signUpEdtPwd.transformationMethod =
                    PasswordTransformationMethod.getInstance()
                //binding.loginEdtPwd.inputType = (InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
                binding.signUpEdtPwd.setSelection(binding.signUpEdtPwd.length())
            }
        }

        //passwd check toggle 버튼 동작 메소드드
        binding.signUpBtnPasswdCheckToggle.setOnClickListener {
            if (!isPwdCheckToggle) {
                isPwdCheckToggle = true
                binding.signUpBtnPasswdCheckToggle.setImageResource(R.drawable.close_eye_img)
                binding.signUpEdtPwdCheck.transformationMethod =
                    SingleLineTransformationMethod.getInstance()
                //binding.loginEdtPwd.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                binding.signUpEdtPwdCheck.setSelection(binding.signUpEdtPwdCheck.length())
            } else {
                isPwdCheckToggle = false
                binding.signUpBtnPasswdCheckToggle.setImageResource(R.drawable.open_eye_img)
                binding.signUpEdtPwdCheck.transformationMethod =
                    PasswordTransformationMethod.getInstance()
                //binding.loginEdtPwd.inputType = (InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
                binding.signUpEdtPwdCheck.setSelection(binding.signUpEdtPwdCheck.length())
            }
        }



        //확인 버튼 클릭 리스너
        binding.signUpBtnOk.setOnClickListener {
            val bottomSheet = SignUpDialog()
            var bundle = Bundle()
            bundle.putString("email",binding.signUpEdtId.text.toString())
            bundle.putString("password",binding.signUpEdtPwd.text.toString())
            bottomSheet!!.arguments = bundle
            bottomSheet.show(supportFragmentManager,bottomSheet.tag)
        }
    }

    fun isEmailValid(email: String?): Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern: Pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher: Matcher = pattern.matcher(email)
        return matcher.matches()
    }

}