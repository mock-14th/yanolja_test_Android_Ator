package com.example.rising_test_yanolja.src.main.myNear.sub.Product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rising_test_yanolja.databinding.ItemMyNearProductRcviewBinding

class MyNearSubProductRcAdapter(private var productList : ArrayList<String>) : RecyclerView.Adapter<MyNearSubProductRcAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyNearSubProductRcAdapter.ViewHolder {
        var binding : ItemMyNearProductRcviewBinding =
            ItemMyNearProductRcviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyNearSubProductRcAdapter.ViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int = productList.size
    inner class ViewHolder(val binding : ItemMyNearProductRcviewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data:String){
            binding.itemMainMyNearProductName.text=data
        }

    }


}