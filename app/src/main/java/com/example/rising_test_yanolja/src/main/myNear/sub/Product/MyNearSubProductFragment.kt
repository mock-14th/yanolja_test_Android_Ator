package com.example.rising_test_yanolja.src.main.myNear.sub.Product

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.BaseFragment
import com.example.rising_test_yanolja.databinding.FragmentMyNearSubProductListBinding
import com.example.rising_test_yanolja.src.main.home.recommend.HomeRecommendTodaySpecialCostRcViewAdapter

class MyNearSubProductFragment : BaseFragment<FragmentMyNearSubProductListBinding>(FragmentMyNearSubProductListBinding::bind, R.layout.fragment_my_near_sub_product_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var productList = ArrayList<String>()
        productList.add("대치 컬리너")
        productList.add("2번")
        productList.add("3번")
        productList.add("4번")
        productList.add("5번")
        productList.add("6번")
        productList.add("7번")
        productList.add("8번")
        productList.add("9번")
        productList.add("10번")


        //today_special_cost_rcView 어댑터 장착
        binding.mainMyNearSubProductRcView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.mainMyNearSubProductRcView.adapter = MyNearSubProductRcAdapter(productList)


    }
}