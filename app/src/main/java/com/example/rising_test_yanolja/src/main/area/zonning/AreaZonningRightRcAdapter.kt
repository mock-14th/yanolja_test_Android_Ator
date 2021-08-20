package com.example.rising_test_yanolja.src.main.area.zonning

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rising_test_yanolja.databinding.ItemMainAreaZonningRightRcviewBinding

class AreaZonningRightRcAdapter(private var areaList : ArrayList<String>) : RecyclerView.Adapter<AreaZonningRightRcAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AreaZonningRightRcAdapter.ViewHolder {
        val binding =
            ItemMainAreaZonningRightRcviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AreaZonningRightRcAdapter.ViewHolder, position: Int) {
        holder.bind(areaList[position])
    }

    override fun getItemCount(): Int = areaList.size

    inner class ViewHolder(var binding : ItemMainAreaZonningRightRcviewBinding) :
            RecyclerView.ViewHolder(binding.root){
                fun bind(data : String){
                    binding.itemMainAreaZonningLeftTx.text=data
                    binding.root.setOnClickListener {

                    }
                }
            }
}