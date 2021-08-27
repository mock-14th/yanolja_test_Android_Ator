package com.example.rising_test_yanolja.src.signUp

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.os.CountDownTimer
import android.telephony.PhoneNumberFormattingTextWatcher
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.ApplicationClass
import com.example.rising_test_yanolja.config.BaseActivity
import com.example.rising_test_yanolja.databinding.ActivitySignUp2Binding
import com.example.rising_test_yanolja.src.main.MainActivity
import com.example.rising_test_yanolja.src.signUp.models.PostSignUpRequest
import com.example.rising_test_yanolja.src.signUp.models.SignUpResponse
import java.util.regex.Matcher
import java.util.regex.Pattern

class SignUpActivity2 : BaseActivity<ActivitySignUp2Binding>(ActivitySignUp2Binding::inflate),SignUpActivity2View {

    private fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //입력 받은 사용자 email, password 저장
        var email = intent.getStringExtra("email")
        var password = intent.getStringExtra("password")



        //edt phone 텍스트 체인지 리스터
        binding.signUp2EdtPhone.addTextChangedListener(object : PhoneNumberFormattingTextWatcher() {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                super.onTextChanged(s, start, before, count)
                var inputPhone = binding.signUp2EdtPhone.text.toString()
                binding.signUp2IdImgOk.visibility = View.INVISIBLE

                if (!inputPhone.isEmpty())
                    binding.signUp2BtnIdReset.visibility = View.VISIBLE
                else
                    binding.signUp2BtnIdReset.visibility = View.INVISIBLE

                if (inputPhone.length > 12)
                    binding.signUp2BtnSend.isEnabled = true
            }
        })





        //edt phone 포커싱 리스너너
        binding.signUp2EdtPhone.setOnFocusChangeListener { v, hasFocus ->
            var inputPhone = binding.signUp2EdtPhone.text.toString()

            if (hasFocus) {
                binding.signUp2IdImgOk.visibility = View.INVISIBLE
                if (!inputPhone.isEmpty())
                        binding.signUp2BtnIdReset.visibility = View.VISIBLE
            } else {
                binding.signUp2BtnIdReset.visibility = View.INVISIBLE
            }



            //인증번호 전송 버튼 클릭 리스너
            binding.signUp2BtnSend.setOnClickListener {

                var timer = 88

                //화면을 변환 시켜주기위해 visible을 바꿔줌
                binding.signUp2BtnSend.visibility = View.INVISIBLE
                binding.signUp2BtnResend.visibility = View.VISIBLE
                binding.signUp2IdImgOk.visibility = View.VISIBLE
                binding.signUp2BtnIdReset.visibility = View.INVISIBLE
                binding.signUp2TextInputLayoutVertification.visibility = View.VISIBLE
                binding.signUp2BottomNavigationView.visibility = View.VISIBLE
                binding.signUp2TxTimer.visibility=View.VISIBLE

                //버튼이 눌리면 edt vertification으로 강제 포커싱을 준다.
                binding.signUp2EdtVertification.post(Runnable {
                    binding.signUp2EdtVertification.setFocusableInTouchMode(true)
                    binding.signUp2EdtVertification.requestFocus()
                    val imm: InputMethodManager =
                        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.showSoftInput(binding.signUp2EdtVertification, 0)
                })


                //타이머 구현할 코드
                object : CountDownTimer(88000, 1000) {
                    override fun onTick(p0: Long) {
                        if(timer>59){
                            binding.signUp2TxTimer.text="1분 ${timer-60}초"
                            timer--
                        }else{
                            binding.signUp2TxTimer.text="0분 ${timer}초"
                            timer--
                        }
                    }
                    override fun onFinish() {

                    }
                }.start()


                //인증번호를 보냈다는 toast
                var toast = Toast(this)
                var toastView = View.inflate(this, R.layout.toast_sign_up_2_send,null)
                toast.view=toastView
                toast.setGravity(Gravity.TOP or Gravity.CENTER,0,50.toPx())
                toast.show()

            }


            //edt 인증번호 6자리 텍스트 체인지 리스너
            binding.signUp2EdtVertification.addTextChangedListener(object:TextWatcher{
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    var inputVertification = binding.signUp2EdtVertification.text.toString()

                    if(inputVertification.length==6)
                        binding.signUp2BtnSignUpComplete.isEnabled=true
                }

                override fun afterTextChanged(s: Editable?) {
                }

            })
        }



     //회원가입 완료 버튼 클릭 리스너
     binding.signUp2BtnSignUpComplete.setOnClickListener {
         if(email!=null && password != null){
             var postRequest = PostSignUpRequest(email = email,nickname = "밝은복숭아4223",phone = binding.signUp2EdtPhone.text.toString(),password = password)
             SignUpService(this).tryPostSignUp(postRequest)

         }
     }

    }


    /*
    회원가입 성공 시
     */
    override fun onPostSignUpSuccess(response: SignUpResponse) {
        if(response.isSuccess){
            var editor = ApplicationClass.sSharedPreferences.edit()
            var jwt = response.result.jwt
            println("jwt 값 넘어오?: ${response.result.jwt}")
            editor.putString("X_ACCESS_TOKEN",jwt)
            editor.commit()

            //정보 수신 동의 처리 toast
//            var toast = Toast(this)
//            var toastView = View.inflate(this, R.layout.toast_complete_sign_up,null)
//            var toastText = toastView.findViewById<TextView>(R.id.tvSample)
//            toastText.text="[야놀자] 2021-08-27 광고성 정보 수신 동의 처리 되었습니다."
//            toast.view=toastView
//            toast.setGravity(Gravity.BOTTOM or Gravity.CENTER,0,50.toPx())
//            toast.show()


            val intent = Intent(this, CompleteSignUpActivity::class.java)
            startActivity(intent)


        }else
            Toast.makeText(this,"회원가입 실패 : ${response.message}",Toast.LENGTH_SHORT).show()
    }


    /*
    회원가입 실패 시
     */
    override fun onPostSignUpFailure(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()

    }
}
