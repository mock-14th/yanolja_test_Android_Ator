package com.example.rising_test_yanolja.src.productInfo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rising_test_yanolja.databinding.ItemProductInfoRcPlayThingsBinding
import com.example.rising_test_yanolja.src.productInfo.models.PlayThingsInfo

class ProductInfoPlayThingRcAdapter(private val playthingsList : ArrayList<PlayThingsInfo>) : RecyclerView.Adapter<ProductInfoPlayThingRcAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductInfoPlayThingRcAdapter.ViewHolder {
        val binding =
            ItemProductInfoRcPlayThingsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductInfoPlayThingRcAdapter.ViewHolder, position: Int) {
        holder.bind(playthingsList[position])
    }

    override fun getItemCount(): Int = playthingsList.size

    inner class ViewHolder(var binding : ItemProductInfoRcPlayThingsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: PlayThingsInfo) {
            binding.itemProductInfoRcPlayThingsImg.setImageResource(data.imgResource)
            binding.itemProductInfoRcPlayThingsTxTitle.text=data.title
            binding.itemProductInfoRcPlayThingsTxDiscount.text=data.discount
            binding.itemProductInfoRcPlayThingsTxPrice.text = data.price
        }
    }
}