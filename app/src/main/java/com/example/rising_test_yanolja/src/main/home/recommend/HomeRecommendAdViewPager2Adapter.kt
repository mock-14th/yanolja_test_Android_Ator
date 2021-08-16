package com.example.rising_test_yanolja.src.main.home.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rising_test_yanolja.databinding.ItemMainHomeRecommendAdViewpagerBinding

class HomeRecommendAdViewPager2Adapter(private val adImgList : ArrayList<Int>) : RecyclerView.Adapter<HomeRecommendAdViewPager2Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecommendAdViewPager2Adapter.ViewHolder {
        val binding =
            ItemMainHomeRecommendAdViewpagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: HomeRecommendAdViewPager2Adapter.ViewHolder,
        position: Int
    ) {
        holder.bind(adImgList[position%adImgList.size])
    }

    override fun getItemCount(): Int = Int.MAX_VALUE

    inner class ViewHolder(var binding : ItemMainHomeRecommendAdViewpagerBinding ) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: Int) {
            binding.itemMainHomeRecommendAdImg.setImageResource(data)
        }
    }

}