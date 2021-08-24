package com.example.rising_test_yanolja.src.productInfo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rising_test_yanolja.databinding.ItemProductInfoRcViewBinding
import com.example.rising_test_yanolja.src.productInfo.models.Room
import java.text.DecimalFormat

class ProductInfoRoomRcAdapter (private val roomList : ArrayList<Room>) : RecyclerView.Adapter<ProductInfoRoomRcAdapter.ViewHolder>() {
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
        fun bind(data: Room) {
            binding.itemProductInfoRcTxRoomName.text=data.roomType
            binding.itemProductInfoRcTxPersonnel.text = "기준 ${data.basePersonnel}명 / 최대 ${data.totalPersonnel}명"
            Glide.with(binding.root).load(data.roomImg).into(binding.itemProductInfoRcImg)

            var formatter = DecimalFormat("###,###")

            if(data.halfDayPrice==null || data.halfDayPrice=="예약마감"){
                binding.itemProductInfoRcTxHalfDayPrice.text="예약마감"
            }else{
                binding.itemProductInfoRcTxHalfDayPrice.text= formatter.format(data.halfDayPrice.toInt())
            }

            if(data.oneDayPrice==null || data.oneDayPrice=="예약마감"){
                binding.itemProductInfoRcTxOneDayPrice.text="예약마감"
            }else{
                binding.itemProductInfoRcTxOneDayPrice.text=formatter.format(data.oneDayPrice.toInt())
            }

            binding.itemProductInfoRcTxTimeOneDay.text="${data.checkInTime} 부터"


            binding.root.setOnClickListener {

            }
        }
    }
}