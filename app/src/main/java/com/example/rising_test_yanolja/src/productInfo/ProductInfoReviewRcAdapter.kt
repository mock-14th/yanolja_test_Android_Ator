package com.example.rising_test_yanolja.src.productInfo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rising_test_yanolja.databinding.ItemProductInfoRcPlayThingsBinding
import com.example.rising_test_yanolja.databinding.ItemProductInfoRcReviewBinding
import com.example.rising_test_yanolja.src.productInfo.models.PlayThingsInfo
import com.example.rising_test_yanolja.src.productInfo.models.Review

class ProductInfoReviewRcAdapter (private val reviewList : ArrayList<Review>) : RecyclerView.Adapter<ProductInfoReviewRcAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductInfoReviewRcAdapter.ViewHolder {
        val binding =
            ItemProductInfoRcReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductInfoReviewRcAdapter.ViewHolder, position: Int) {
        holder.bind(reviewList[position])
    }

    override fun getItemCount(): Int = reviewList.size

    inner class ViewHolder(var binding : ItemProductInfoRcReviewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: Review) {
            Glide.with(binding.root).load(data.postscriptImg).into(binding.itemProductInfoRcRoomPicture)
            binding.itemProductInfoRcReviewImgRating.setStar(data.rating.toFloat())
            binding.itemProductInfoRcContent.text=data.content

            var date = data.postscriptDate.split("-")
            binding.itemProductInfoRcTxTime.text="${date[0]}-${date[1]}-${date[2]}"

            binding.itemProductInfoRcTxNickname.text=data.nickname
            binding.itemProductInfoRcTxRoom.text=data.useRoom

        }
    }
}