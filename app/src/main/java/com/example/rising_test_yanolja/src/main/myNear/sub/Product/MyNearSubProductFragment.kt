package com.example.rising_test_yanolja.src.main.myNear.sub.Product

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.BaseFragment
import com.example.rising_test_yanolja.databinding.FragmentMyNearSubProductListBinding
import com.example.rising_test_yanolja.src.main.home.recommend.HomeRecommendTodaySpecialCostRcViewAdapter
import com.example.rising_test_yanolja.src.main.myNear.sub.Product.models.MyNearSubProductResponse
import com.example.rising_test_yanolja.src.main.myNear.sub.Product.models.ResultMyNearProduct
import com.example.rising_test_yanolja.src.productInfo.ProductInfoReviewRcAdapter
import com.example.rising_test_yanolja.src.productInfo.ProductInfoRoomRcAdapter

class MyNearSubProductFragment : BaseFragment<FragmentMyNearSubProductListBinding>(
    FragmentMyNearSubProductListBinding::bind,
    R.layout.fragment_my_near_sub_product_list
), MyNearSubProductFragmentView {

    var productList = ArrayList<ResultMyNearProduct>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var handler = Handler(Looper.getMainLooper())

        Thread {
            handler.post {
                showLoadingDialog(requireContext())
                MyNearSubProductService(this).tryGetMotelsList()
            }
        }.start()


    }

    //통신 성공
    override fun onGetMotelsListSuccess(response: MyNearSubProductResponse) {
        if (response.isSuccess) {
            var handler = Handler(Looper.getMainLooper())

            for (i in response.result) {
                productList.add(i)
            }
            Thread {
                handler.post {
                    //today_special_cost_rcView 어댑터 장착
                    binding.mainMyNearSubProductRcView.layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    binding.mainMyNearSubProductRcView.adapter =
                        MyNearSubProductRcAdapter(productList)
                }
            }.start()

            dismissLoadingDialog()
        }
    }

    //통신 오류
    override fun onGetMotelsListFailure(message: String) {
        showCustomToast("통신 실패")
    }
}
