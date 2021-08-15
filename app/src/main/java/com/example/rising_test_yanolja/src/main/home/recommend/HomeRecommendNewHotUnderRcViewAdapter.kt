package com.example.rising_test_yanolja.src.main.home.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rising_test_yanolja.databinding.ItemMainHomeRecommendNewHotUnderRcviewBinding
import com.example.rising_test_yanolja.src.main.home.recommend.model.NewHotUnderInfo

class HomeRecommendNewHotUnderRcViewAdapter (private var newHotUnderList : ArrayList<NewHotUnderInfo>) : RecyclerView.Adapter<HomeRecommendNewHotUnderRcViewAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecommendNewHotUnderRcViewAdapter.ViewHolder {
        val binding =
            ItemMainHomeRecommendNewHotUnderRcviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeRecommendNewHotUnderRcViewAdapter.ViewHolder, position: Int) {
        holder.bind(newHotUnderList[position])
    }

    override fun getItemCount(): Int = newHotUnderList.size

    inner class ViewHolder(val binding : ItemMainHomeRecommendNewHotUnderRcviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: NewHotUnderInfo) {
            binding.itemMainHomeRecommendNewHotUnderLinear.setOnClickListener {

            }
            binding.itemMainHomeRecommendNewHotUnderImg.setImageResource(data.imgResource)
            binding.itemMainHomeRecommendNewHotUnderTx.text=data.title
        }
    }

}