package com.example.rising_test_yanolja.src.main.myNear.sub

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.rising_test_yanolja.src.main.myNear.sub.Product.MyNearSubProductFragment

class MyNearSubViewPager2Adapter(fm: Fragment) : FragmentStateAdapter(fm){
    override fun getItemCount(): Int = 6

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> MyNearSubProductFragment()
            1-> MyNearSubProductFragment()
            2-> MyNearSubProductFragment()
            3-> MyNearSubProductFragment()
            4-> MyNearSubProductFragment()
            5-> MyNearSubProductFragment()
            else-> MyNearSubProductFragment()
        }
    }
}