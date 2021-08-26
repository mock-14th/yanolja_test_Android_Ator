package com.example.rising_test_yanolja.src.main.myNear.sub.Product

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.databinding.ItemMyNearProductRcviewBinding
import com.example.rising_test_yanolja.src.main.myNear.sub.Product.models.ResultMyNearProduct
import com.example.rising_test_yanolja.src.productInfo.ProductInfoActivity
import java.text.DecimalFormat

class MyNearSubProductRcAdapter(private var productList : ArrayList<ResultMyNearProduct>) : RecyclerView.Adapter<MyNearSubProductRcAdapter.ViewHolder>(){
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
        fun bind(data:ResultMyNearProduct){
            //가격에 ,붙히기 위한 포맷
            var formatter = DecimalFormat("###,###")

            //상품 클릭하면 productInfo 클래스로 이동
            binding.root.setOnClickListener {
                var intent = Intent(binding.root.context,ProductInfoActivity::class.java)
                intent.putExtra("brandID",data.id)
                binding.root.context.startActivity(intent)
            }

            Glide.with(binding.root).load(data.picture).into(binding.itemMainMyNearProductImg)
            binding.itemMainMyNearProductName.text = data.name
            binding.itemMainMyNearProductTxRating.text=data.rating
            binding.itemMainMyNearProductImgRating.rating=data.rating.toFloat()
            binding.itemMainMyNearProductTxReview.text="(${data.review.toString()})"
            binding.itemMainMyNearProductTxCatogry.text=data.category

            //대실의 값이 0이면 아예 안보이게
            if(data.halfDay.toString()=="0"){
                binding.itemMainMyNearProductLinearHalfday.visibility=View.INVISIBLE
            }else
                binding.itemMainMyNearProductTxHalfdayPrice.text=formatter.format(data.halfDay)

            //가격이 예약마감이라면 원과 시간 안보이도록
            if(data.oneDay=="예약마감") {
                binding.itemMainMyNearProductTxOnedayPrice.text = data.oneDay
                binding.itemMainMyNearProductTxWonOneday.visibility= View.GONE
                binding.itemMainMyNearProductTxOnedayFromTime.visibility=View.GONE
                binding.itemMainMyNearProductTxOnedayPrice.setTextColor(Color.parseColor("#4a4a4a"))
                binding.itemMainMyNearProductTxOnedayPrice.textSize=12f
            } else
                binding.itemMainMyNearProductTxOnedayPrice.text=formatter.format(data.oneDay.toInt())

        }

    }


}