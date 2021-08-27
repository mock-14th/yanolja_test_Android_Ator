package com.example.rising_test_yanolja.src.main.like


import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rising_test_yanolja.databinding.ItemLikeLoginRcViewBinding
import com.example.rising_test_yanolja.src.main.like.models.Result
import java.text.DecimalFormat

class AdapterLikeLoginFragment (private var productList : ArrayList<Result>) : RecyclerView.Adapter<AdapterLikeLoginFragment.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterLikeLoginFragment.ViewHolder {
        var binding : ItemLikeLoginRcViewBinding =
            ItemLikeLoginRcViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterLikeLoginFragment.ViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int = productList.size
    inner class ViewHolder(val binding : ItemLikeLoginRcViewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: Result) {
            var formatter = DecimalFormat("###,###")

            binding.itemLikeLoginReviewImgRating.rating=data.rating.toFloat()
            binding.itemLikeTxRoomName.text = data.brandName
            binding.itemLikeTxRating.text=data.rating
            binding.itemLikeTxReviewCount.text=data.ratingCount.toString()

            if(data.halfDayPrice!="예약마감" && data.halfDayPrice!=null){
                binding.itemLikeTxHalfdayPrice.text=formatter.format(data.halfDayPrice.toInt())
            }else if(data.halfDayPrice==null){
                binding.itemLikeHalfdayLinear.visibility=View.INVISIBLE
            }
            else{
                binding.itemLikeTxHalfdayPrice.setTextColor(Color.parseColor("#4a4a4a"))
                binding.itemLikeTxHalfdayPrice.textSize=12f
                binding.itemLikeTxHalfdayPrice.text=data.halfDayPrice
                binding.itemLikeTxHalfdayWon.visibility= View.INVISIBLE
            }

            if(data.oneDayPrice!="예약마감"&& data.oneDayPrice!=null){
                binding.itemLikeTxOnedayPrice.text=formatter.format(data.oneDayPrice.toInt())
            }
            else{
                binding.itemLikeTxOnedayPrice.setTextColor(Color.parseColor("#4a4a4a"))
                binding.itemLikeTxOnedayPrice.textSize=12f
                binding.itemLikeTxOnedayPrice.text=data.oneDayPrice
                binding.itemLikeTxWonOneday.visibility= View.INVISIBLE
            }

        }

    }


}