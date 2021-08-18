package com.example.rising_test_yanolja.src.login.yanolja

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.text.method.SingleLineTransformationMethod
import android.view.View
import android.widget.Toast
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.rising_test_yanolja.config.ApplicationClass.Companion.sSharedPreferences
import com.example.rising_test_yanolja.config.BaseFragment
import com.example.rising_test_yanolja.databinding.FragmentYanoljaLoginBinding
import com.example.rising_test_yanolja.src.login.yanolja.models.LoginResponse
import com.example.rising_test_yanolja.src.login.yanolja.models.PostLoginRequest
import com.example.rising_test_yanolja.src.main.MainActivity

class YanoljaLoginFragment : BaseFragment<FragmentYanoljaLoginBinding>(FragmentYanoljaLoginBinding::bind, R.layout.fragment_yanolja_login), YanoljaLoginFragmentView{
    private var isIdInput = false
    private var isPwdInput = false
    private var isPwdToggle = false
    private var currentViewPagerIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        currentViewPagerIndex = arguments?.getInt("currentViewPagerIndex")!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginBtnLogin.setOnClickListener {
            val postRequest = PostLoginRequest(email=binding.loginEdtId.text.toString(),password = binding.loginEdtPwd.text.toString())
            YanoljaLoginService(this).tryPostLogin(postRequest)
        }




        //IdEdtText에 입력이 되었는지 확인하는 코드
        binding.loginEdtId.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.loginEdtId.length() != 0) {
                    isIdInput = true
                    if (isIdInput && isPwdInput) {
                        binding.loginBtnLogin.isEnabled = true
                    }
                } else {
                    isIdInput = false
                    binding.loginBtnLogin.isEnabled = false
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        //PasswordEdtText에 입력이 되었는지 확인하는 코드
        binding.loginEdtPwd.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.loginEdtPwd.length() != 0) {
                    isPwdInput = true
                    binding.loginBtnPasswdToggle.visibility = View.VISIBLE
                    if (isIdInput && isPwdInput) {
                        binding.loginBtnLogin.isEnabled = true
                    }
                } else {
                    isPwdInput = false
                    binding.loginBtnPasswdToggle.visibility = View.INVISIBLE
                    binding.loginBtnLogin.isEnabled = false
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })


        //passwd toggle 버튼 동작 메소드드
        binding.loginBtnPasswdToggle.setOnClickListener {
            if (!isPwdToggle) {
                isPwdToggle = true
                binding.loginBtnPasswdToggle.setImageResource(R.drawable.close_eye_img)
                binding.loginEdtPwd.transformationMethod =
                    SingleLineTransformationMethod.getInstance()
                //binding.loginEdtPwd.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                binding.loginEdtPwd.setSelection(binding.loginEdtPwd.length())
            } else {
                isPwdToggle = false
                binding.loginBtnPasswdToggle.setImageResource(R.drawable.open_eye_img)
                binding.loginEdtPwd.transformationMethod =
                    PasswordTransformationMethod.getInstance()
                //binding.loginEdtPwd.inputType = (InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
                binding.loginEdtPwd.setSelection(binding.loginEdtPwd.length())
            }
        }

    }


    /*
    로그인 성공 시
     */
    override fun onPostLoginSuccess(response: LoginResponse) {
        var editor = sSharedPreferences.edit()
        if(response.isSuccess){
            var jwt = response.result.jwt
            editor.putString(X_ACCESS_TOKEN,jwt)

            val intent = Intent(context,MainActivity::class.java)
            intent.putExtra("currentViewPagerIndex",currentViewPagerIndex)
            startActivity(intent)

            Toast.makeText(context,"로그인 성공",Toast.LENGTH_SHORT).show()
        }else
            Toast.makeText(context,"로그인 실패 : ${response.message}",Toast.LENGTH_SHORT).show()



    }


    /*
    로그인 실패 시
     */
    override fun onPostLoginFailure(message: String) {
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
    }
}