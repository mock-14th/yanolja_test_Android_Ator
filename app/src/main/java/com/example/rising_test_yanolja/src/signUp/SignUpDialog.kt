package com.example.rising_test_yanolja.src.signUp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.databinding.DialogSignUp1BottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SignUpDialog : BottomSheetDialogFragment() {
    private lateinit var binding: DialogSignUp1BottomSheetBinding
    private var isAllAgree = false
    private var isAgree1 = false
    private var isAgree2 = false
    private var isAgree3 = false
    private var isAgree4 = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogSignUp1BottomSheetBinding.inflate(layoutInflater)

        //입력 받은 사용자 email, password 저장
        var email = arguments?.getString("email","")
        var password =arguments?.getString("password","")


        binding.signUp1BottomSheetBtnAllAgree.setOnClickListener {
            if (!isAllAgree){
                isAllAgree=true
                isAgree1=true
                isAgree2=true
                isAgree3=true
                isAgree4=true

                binding.signUp1BottomSheetImgRoundCheck.setImageResource(R.drawable.bottom_sheet_round_check_blue_img)
                binding.imgCheck1.setImageResource(R.drawable.check_blue_img)
                binding.imgCheck2.setImageResource(R.drawable.check_blue_img)
                binding.imgCheck3.setImageResource(R.drawable.check_blue_img)
                binding.imgCheck4.setImageResource(R.drawable.check_blue_img)
                binding.signUp1BottomSheetBtnAllAgree.setBackgroundResource(R.drawable.bottom_dialog_round_blue_bg)

                binding.signUp1BtnNext.isEnabled = true
            }else{
                isAllAgree=false
                isAgree1=false
                isAgree2=false
                isAgree3=false
                isAgree4=false

                binding.signUp1BottomSheetImgRoundCheck.setImageResource(R.drawable.bottom_sheet_round_check_img)
                binding.imgCheck1.setImageResource(R.drawable.check_gray_img)
                binding.imgCheck2.setImageResource(R.drawable.check_gray_img)
                binding.imgCheck3.setImageResource(R.drawable.check_gray_img)
                binding.imgCheck4.setImageResource(R.drawable.check_gray_img)
                binding.signUp1BottomSheetBtnAllAgree.setBackgroundResource(R.drawable.bottom_dialog_round_bg)


                binding.signUp1BtnNext.isEnabled = false
            }
        }

        binding.imgCheck1.setOnClickListener {
            if(!isAgree1){
                isAgree1=true
                binding.imgCheck1.setImageResource(R.drawable.check_blue_img)
                binding.signUp1BtnNext.isEnabled = true

                if (isAgree1 && isAgree2 && isAgree3 && isAgree4){
                    isAllAgree=true
                    binding.signUp1BottomSheetImgRoundCheck.setImageResource(R.drawable.bottom_sheet_round_check_blue_img)
                    binding.signUp1BottomSheetBtnAllAgree.setBackgroundResource(R.drawable.bottom_dialog_round_blue_bg)
                }


            }else{
                isAgree1=false
                isAllAgree=false
                binding.imgCheck1.setImageResource(R.drawable.check_gray_img)
                binding.signUp1BtnNext.isEnabled = false

                binding.signUp1BottomSheetBtnAllAgree.setBackgroundResource(R.drawable.bottom_dialog_round_bg)
                binding.signUp1BottomSheetImgRoundCheck.setImageResource(R.drawable.bottom_sheet_round_check_img)

            }
        }

        binding.imgCheck2.setOnClickListener {
            if(!isAgree2){
                isAgree2=true
                binding.imgCheck2.setImageResource(R.drawable.check_blue_img)
                if (isAgree1 && isAgree2 && isAgree3 && isAgree4){
                    isAllAgree=true
                    binding.signUp1BottomSheetImgRoundCheck.setImageResource(R.drawable.bottom_sheet_round_check_blue_img)
                    binding.signUp1BottomSheetBtnAllAgree.setBackgroundResource(R.drawable.bottom_dialog_round_blue_bg)
                }


            }else{
                isAgree2=false
                isAllAgree=false
                binding.imgCheck2.setImageResource(R.drawable.check_gray_img)
                binding.signUp1BottomSheetBtnAllAgree.setBackgroundResource(R.drawable.bottom_dialog_round_bg)
                binding.signUp1BottomSheetImgRoundCheck.setImageResource(R.drawable.bottom_sheet_round_check_img)

            }
        }


        binding.imgCheck3.setOnClickListener {
            if(!isAgree3){
                isAgree3=true
                binding.imgCheck3.setImageResource(R.drawable.check_blue_img)
                if (isAgree1 && isAgree2 && isAgree3 && isAgree4){
                    isAllAgree=true
                    binding.signUp1BottomSheetImgRoundCheck.setImageResource(R.drawable.bottom_sheet_round_check_blue_img)
                    binding.signUp1BottomSheetBtnAllAgree.setBackgroundResource(R.drawable.bottom_dialog_round_blue_bg)
                }


            }else{
                isAgree3=false
                isAllAgree=false
                binding.imgCheck3.setImageResource(R.drawable.check_gray_img)
                binding.signUp1BottomSheetBtnAllAgree.setBackgroundResource(R.drawable.bottom_dialog_round_bg)
                binding.signUp1BottomSheetImgRoundCheck.setImageResource(R.drawable.bottom_sheet_round_check_img)

            }
        }


        binding.imgCheck4.setOnClickListener {
            if(!isAgree4){
                isAgree4=true
                binding.imgCheck4.setImageResource(R.drawable.check_blue_img)

                if (isAgree1 && isAgree2 && isAgree3 && isAgree4){
                    isAllAgree=true
                    binding.signUp1BottomSheetImgRoundCheck.setImageResource(R.drawable.bottom_sheet_round_check_blue_img)
                    binding.signUp1BottomSheetBtnAllAgree.setBackgroundResource(R.drawable.bottom_dialog_round_blue_bg)
                }

            }else{
                isAgree4=false
                isAllAgree=false
                binding.imgCheck4.setImageResource(R.drawable.check_gray_img)
                binding.signUp1BottomSheetBtnAllAgree.setBackgroundResource(R.drawable.bottom_dialog_round_bg)
                binding.signUp1BottomSheetImgRoundCheck.setImageResource(R.drawable.bottom_sheet_round_check_img)
            }
        }


        //다음 버튼 클릭 리스너
        binding.signUp1BtnNext.setOnClickListener {
            var intent = Intent(context,SignUpActivity2::class.java)
            intent.putExtra("email",email)
            intent.putExtra("password",password)
            startActivity(intent)
        }



        return binding.root
    }
}