package com.example.rising_test_yanolja.src.main.like

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.ApplicationClass
import com.example.rising_test_yanolja.config.BaseFragment
import com.example.rising_test_yanolja.databinding.FragmentLikeLoginBinding
import com.example.rising_test_yanolja.src.main.like.models.LikeProductResponse
import com.example.rising_test_yanolja.src.main.like.models.Result
class LikeLoginFragment : BaseFragment<FragmentLikeLoginBinding>(FragmentLikeLoginBinding::bind, R.layout.fragment_like_login),LikeLoginFragmentView {
    private lateinit var JWT : String
    private var productList = ArrayList<Result>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        JWT = ApplicationClass.sSharedPreferences.getString("X_ACCESS_TOKEN","").toString()

        LikeLoginService(this).tryGetLikeProduct(JWT,"2021-08-27","2021-08-28",1)



    }

    override fun onGetLikeProductSuccess(response: LikeProductResponse) {
        if (response.isSuccess){
            if(response.result.isNotEmpty()){
                for (i in response.result)
                    productList.add(i)

                binding.mainLikeLoginRcView.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                binding.mainLikeLoginRcView.adapter = AdapterLikeLoginFragment(productList)
            }else{
                binding.mainLikeLinearLoginNoProduct.visibility=View.VISIBLE
                binding.mainLikeLoginRcView.visibility=View.GONE
            }
        }
    }

    override fun onGetLikeProductFailure(message: String) {
    }
}