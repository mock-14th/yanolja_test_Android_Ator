package com.example.rising_test_yanolja.src.productInfo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rising_test_yanolja.databinding.ItemProductInfoRcViewBinding

class ProductInfoRoomRcAdapter (private val roomList : ArrayList<Int>) : RecyclerView.Adapter<ProductInfoRoomRcAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductInfoRoomRcAdapter.ViewHolder {
        val binding =
            ItemProductInfoRcViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductInfoRoomRcAdapter.ViewHolder, position: Int) {
        holder.bind(roomList[position])
    }

    override fun getItemCount(): Int = roomList.size

    inner class ViewHolder(var binding : ItemProductInfoRcViewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: Int) {
        }
    }
}