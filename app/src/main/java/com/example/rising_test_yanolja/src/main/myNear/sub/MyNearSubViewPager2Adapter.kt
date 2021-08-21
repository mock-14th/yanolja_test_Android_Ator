package com.example.rising_test_yanolja.src.main.myNear.sub

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.rising_test_yanolja.src.main.home.enjoy.HomeEnjoyFragment
import com.example.rising_test_yanolja.src.main.home.internalRoom.HomeInternalRoomFragment
import com.example.rising_test_yanolja.src.main.home.overseasTrip.HomeOverseasTripFragment
import com.example.rising_test_yanolja.src.main.home.traffic.HomeTrafficFragment

class MyNearSubViewPager2Adapter(fm: Fragment) : FragmentStateAdapter(fm){
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            //0-> MyNearSubProductList()
            1-> HomeInternalRoomFragment()
            2-> HomeEnjoyFragment()
            3-> HomeTrafficFragment()
            else-> HomeOverseasTripFragment()
        }
    }
}