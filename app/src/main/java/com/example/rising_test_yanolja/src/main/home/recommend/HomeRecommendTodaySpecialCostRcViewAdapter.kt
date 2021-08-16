package com.example.rising_test_yanolja.src.main.home.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rising_test_yanolja.databinding.ItemMainHomeRecommendNewHotUnderRcviewBinding
import com.example.rising_test_yanolja.databinding.ItemMainHomeRecommendTodaySpecialCostRcviewBinding
import com.example.rising_test_yanolja.src.main.home.recommend.model.NewHotUnderInfo

class HomeRecommendTodaySpecialCostRcViewAdapter (private var todaySpecialCostList : ArrayList<Int>) : RecyclerView.Adapter<HomeRecommendTodaySpecialCostRcViewAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecommendTodaySpecialCostRcViewAdapter.ViewHolder {
        val binding =
            ItemMainHomeRecommendTodaySpecialCostRcviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeRecommendTodaySpecialCostRcViewAdapter.ViewHolder, position: Int) {
        holder.bind(todaySpecialCostList[position])
    }

    override fun getItemCount(): Int = todaySpecialCostList.size

    inner class ViewHolder(val binding : ItemMainHomeRecommendTodaySpecialCostRcviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Int) {
           binding.itemMainHomeRecommendTodaySpecialCostImg.setImageResource(data)
        }
    }

}