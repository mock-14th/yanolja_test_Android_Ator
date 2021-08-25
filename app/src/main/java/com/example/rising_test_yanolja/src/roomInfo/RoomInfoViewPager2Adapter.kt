package com.example.rising_test_yanolja.src.roomInfo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rising_test_yanolja.databinding.ItemRoomInfoViewPagerBinding

class RoomInfoViewPager2Adapter (private val roomImgList : ArrayList<String>) : RecyclerView.Adapter<RoomInfoViewPager2Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomInfoViewPager2Adapter.ViewHolder {
        val binding =
            ItemRoomInfoViewPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RoomInfoViewPager2Adapter.ViewHolder, position: Int) {
        holder.bind(roomImgList[position])
    }

    override fun getItemCount(): Int = roomImgList.size

    inner class ViewHolder(var binding : ItemRoomInfoViewPagerBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: String) {
            Glide.with(binding.root).load(data).into(binding.itemProductThumnailViewPagerImg)
        }
    }
}