package com.example.rising_test_yanolja.src.main.home.recommend

import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rising_test_yanolja.databinding.ItemMainHomeRecommendTodayMagazineRcviewBinding
import com.example.rising_test_yanolja.src.main.home.recommend.model.TodayMagazineInfo

class HomeRecommendTodayMagazineRcViewAdapter (private var todayMagazineList : ArrayList<TodayMagazineInfo>) : RecyclerView.Adapter<HomeRecommendTodayMagazineRcViewAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecommendTodayMagazineRcViewAdapter.ViewHolder {
        val binding =
            ItemMainHomeRecommendTodayMagazineRcviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeRecommendTodayMagazineRcViewAdapter.ViewHolder, position: Int) {
        holder.bind(todayMagazineList[position])
    }

    override fun getItemCount(): Int = todayMagazineList.size

    inner class ViewHolder(val binding : ItemMainHomeRecommendTodayMagazineRcviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: TodayMagazineInfo) {
            binding.itemMainHomeRecommendImgTodayMagazine.setImageResource(data.imgResource)
            binding.itemMainHomeRecommendImgTodayMagazine.setColorFilter(Color.parseColor("#BDBDBD"), PorterDuff.Mode.MULTIPLY);
            binding.itemMainHomeRecommendTodayMagazineTxCategory.text = data.category
            binding.itemMainHomeRecommendTodayMagazineTxExplane.text = data.explane
        }
    }
}