package com.example.rising_test_yanolja.src.main.home.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rising_test_yanolja.databinding.ItemMainHomeRecommendWeeklyTopViewpagerBinding

class HomeRecommendWeeklyTopViewPager2Adapter(private val weeklyImgList : ArrayList<Int>) : RecyclerView.Adapter<HomeRecommendWeeklyTopViewPager2Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecommendWeeklyTopViewPager2Adapter.ViewHolder {
        val binding =
            ItemMainHomeRecommendWeeklyTopViewpagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: HomeRecommendWeeklyTopViewPager2Adapter.ViewHolder,
        position: Int
    ) {
        holder.bind(weeklyImgList[position%weeklyImgList.size])
    }

    override fun getItemCount(): Int = weeklyImgList.size

    inner class ViewHolder(var binding : ItemMainHomeRecommendWeeklyTopViewpagerBinding ) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: Int) {
            binding.itemMainHomeRecommendWeeklyTopImg.setImageResource(data)
        }
    }

}