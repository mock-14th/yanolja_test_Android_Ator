package com.example.rising_test_yanolja.src.productInfo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rising_test_yanolja.databinding.ItemMainHomeRecommendAdViewpagerBinding
import com.example.rising_test_yanolja.databinding.ItemProductThumnailViewPagerBinding
import com.example.rising_test_yanolja.src.main.home.recommend.HomeRecommendAdViewPager2Adapter

class ProductInfoThumnailViewPager2Adapter(private val adImgList : ArrayList<Int>) : RecyclerView.Adapter<ProductInfoThumnailViewPager2Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductInfoThumnailViewPager2Adapter.ViewHolder {
        val binding =
            ItemProductThumnailViewPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductInfoThumnailViewPager2Adapter.ViewHolder, position: Int) {
        holder.bind(adImgList[position])
    }

    override fun getItemCount(): Int = adImgList.size

    inner class ViewHolder(var binding : ItemProductThumnailViewPagerBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: Int) {
            binding.itemProductThumnailViewPagerImg.setImageResource(data)
        }
    }
}