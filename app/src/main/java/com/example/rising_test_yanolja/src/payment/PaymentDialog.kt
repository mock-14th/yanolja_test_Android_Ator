package com.example.rising_test_yanolja.src.payment

import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.rising_test_yanolja.databinding.DialogPaymentBottomSheetBinding
import com.example.rising_test_yanolja.databinding.DialogSignUp1BottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PaymentDialog : BottomSheetDialogFragment() {
    private lateinit var binding : DialogPaymentBottomSheetBinding

    var startDate = " "
    var endDate =" "
    var roomType = " "
    var checkIn = " "
    var checkOut = " "
    var brandName = " "
    var startDayOfWeek =" "
    var endDayOfWeek = " "
    var oneDayPrice =" "


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= DialogPaymentBottomSheetBinding.inflate(layoutInflater)

        startDate=requireArguments().getString("startDate","")
        endDate=requireArguments().getString("endDate","")
        roomType=requireArguments().getString("roomType","")
        brandName=requireArguments().getString("brandName","")
        startDayOfWeek=requireArguments().getString("startDayOfWeek","")
        oneDayPrice=requireArguments().getString("oneDayPrice","")

        binding.paymentTxBrandName.text=brandName
        binding.paymentTxPeriod.text="${startDate} (${startDayOfWeek}) ~ ${endDate} (${endDayOfWeek})"
        binding.paymentTxRoomType.text=roomType

        return binding.root
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), theme)
        dialog.setOnShowListener {

            val bottomSheetDialog = it as BottomSheetDialog
            val parentLayout =
                bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            parentLayout?.let { it ->
                val behaviour = BottomSheetBehavior.from(it)
                setupFullHeight(it)
                behaviour.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
        return dialog
    }

    private fun setupFullHeight(bottomSheet: View) {
        val layoutParams = bottomSheet.layoutParams
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
        bottomSheet.layoutParams = layoutParams
    }
}