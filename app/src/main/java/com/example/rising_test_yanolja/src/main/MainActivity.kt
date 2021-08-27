package com.example.rising_test_yanolja.src.main

import android.os.Bundle
import com.example.rising_test_yanolja.R
import com.example.rising_test_yanolja.config.BaseActivity
import com.example.rising_test_yanolja.databinding.ActivityMainBinding
import com.example.rising_test_yanolja.src.main.area.AreaFragment
import com.example.rising_test_yanolja.src.main.home.HomeFragment
import com.example.rising_test_yanolja.src.main.like.LikeFragment
import com.example.rising_test_yanolja.src.main.myNear.MyNearFragment
import com.example.rising_test_yanolja.src.main.myYanolja.MyYanoljaFragment

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate){

    private var fmHome : HomeFragment? = null
    private var fmArea : AreaFragment? = null
    private var fmMyNear : MyNearFragment? = null
    private var fmLike : LikeFragment? = null
    private var fmMyYanolja : MyYanoljaFragment? = null
    private var currentViewPagerIndex = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        currentViewPagerIndex=intent.getIntExtra("currentViewPagerIndex",0)

        when(currentViewPagerIndex){
            0->{
                fmHome = HomeFragment()
                supportFragmentManager.beginTransaction().add(R.id.main_frameLayout,fmHome!!).commitAllowingStateLoss()
                binding.mainHomeBottomNav.menu.getItem(0).isChecked=true

            }
            1->{
                fmArea = AreaFragment()
                supportFragmentManager.beginTransaction()
                    .add(R.id.main_frameLayout, fmArea!!).commitAllowingStateLoss()
                binding.mainHomeBottomNav.menu.getItem(1).isChecked=true

            }
            2->{
                fmMyNear = MyNearFragment()
                supportFragmentManager.beginTransaction()
                    .add(R.id.main_frameLayout, fmMyNear!!).commitAllowingStateLoss()
                binding.mainHomeBottomNav.menu.getItem(2).isChecked=true

            }
            3->{
                fmLike = LikeFragment()
                supportFragmentManager.beginTransaction()
                    .add(R.id.main_frameLayout, fmLike!!).commitAllowingStateLoss()
                binding.mainHomeBottomNav.menu.getItem(3).isChecked=true
            }
            4->{
                fmMyYanolja = MyYanoljaFragment()
                supportFragmentManager.beginTransaction()
                    .add(R.id.main_frameLayout, fmMyYanolja!!)
                    .commitAllowingStateLoss()
                binding.mainHomeBottomNav.menu.getItem(4).isChecked=true

            }
        }

        /*
        bottom navigation view click listener
        네비게이션 버튼을 클릭하면 해당 fragment가 null인지 확인하고 null이면 add로 생성 아니면 show로 보여주고 나머지 fragment는 hide로 숨겨 데이터를 유지할 수 있도록 구현
         */
        binding.mainHomeBottomNav.setOnNavigationItemSelectedListener { item ->



            when (item.itemId) {
                R.id.main_home_bottomNava_home -> {
                    binding.mainHomeBottomNav.menu.getItem(0).isChecked=true
                    if (fmHome == null) {
                        fmHome = HomeFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frameLayout, fmHome!!).commitAllowingStateLoss()
                    }
                    if (fmHome != null) supportFragmentManager.beginTransaction().show(fmHome!!)
                        .commitAllowingStateLoss()
                    if (fmArea != null) supportFragmentManager.beginTransaction().hide(fmArea!!)
                        .commitAllowingStateLoss()
                    if (fmMyNear != null) supportFragmentManager.beginTransaction().hide(fmMyNear!!)
                        .commitAllowingStateLoss()
                    if (fmLike != null) supportFragmentManager.beginTransaction().hide(fmLike!!)
                        .commitAllowingStateLoss()
                    if (fmMyYanolja != null) supportFragmentManager.beginTransaction()
                        .hide(fmMyYanolja!!).commitAllowingStateLoss()
                }


                R.id.main_home_bottomNava_area -> {
                    binding.mainHomeBottomNav.menu.getItem(1).isChecked=true
                    if (fmArea == null) {
                        fmArea = AreaFragment()
                        supportFragmentManager.beginTransaction()
                            .add(R.id.main_frameLayout, fmArea!!).commitAllowingStateLoss()
                    }
                    if (fmHome != null) supportFragmentManager.beginTransaction().hide(fmHome!!)
                        .commitAllowingStateLoss()
                    if (fmArea != null) supportFragmentManager.beginTransaction().show(fmArea!!)
                        .commitAllowingStateLoss()
                    if (fmMyNear != null) supportFragmentManager.beginTransaction().hide(fmMyNear!!)
                        .commitAllowingStateLoss()
                    if (fmLike != null) supportFragmentManager.beginTransaction().hide(fmLike!!)
                        .commitAllowingStateLoss()
                    if (fmMyYanolja != null) supportFragmentManager.beginTransaction()
                        .hide(fmMyYanolja!!).commitAllowingStateLoss()
                }


                R.id.main_home_bottomNava_my_near -> {
                    binding.mainHomeBottomNav.menu.getItem(2).isChecked=true
                    if (fmMyNear == null) {
                        fmMyNear = MyNearFragment()
                        supportFragmentManager.beginTransaction()
                            .add(R.id.main_frameLayout, fmMyNear!!).commitAllowingStateLoss()
                    }
                    if (fmHome != null) supportFragmentManager.beginTransaction().hide(fmHome!!)
                        .commitAllowingStateLoss()
                    if (fmArea != null) supportFragmentManager.beginTransaction().hide(fmArea!!)
                        .commitAllowingStateLoss()
                    if (fmMyNear != null) supportFragmentManager.beginTransaction().show(fmMyNear!!)
                        .commitAllowingStateLoss()
                    if (fmLike != null) supportFragmentManager.beginTransaction().hide(fmLike!!)
                        .commitAllowingStateLoss()
                    if (fmMyYanolja != null) supportFragmentManager.beginTransaction()
                        .hide(fmMyYanolja!!).commitAllowingStateLoss()
                }


                R.id.main_home_bottomNava_like -> {
                    binding.mainHomeBottomNav.menu.getItem(3).isChecked=true
                    if (fmLike == null) {
                        fmLike = LikeFragment()
                        supportFragmentManager.beginTransaction()
                            .add(R.id.main_frameLayout, fmLike!!).commitAllowingStateLoss()
                    }
                    if (fmHome != null) supportFragmentManager.beginTransaction().hide(fmHome!!)
                        .commitAllowingStateLoss()
                    if (fmArea != null) supportFragmentManager.beginTransaction().hide(fmArea!!)
                        .commitAllowingStateLoss()
                    if (fmMyNear != null) supportFragmentManager.beginTransaction().hide(fmMyNear!!)
                        .commitAllowingStateLoss()
                    if (fmLike != null) supportFragmentManager.beginTransaction().show(fmLike!!)
                        .commitAllowingStateLoss()
                    if (fmMyYanolja != null) supportFragmentManager.beginTransaction()
                        .hide(fmMyYanolja!!).commitAllowingStateLoss()
                }

                R.id.main_home_bottomNava_my_yanolja -> {
                    binding.mainHomeBottomNav.menu.getItem(4).isChecked=true
                    if (fmMyYanolja == null) {
                        fmMyYanolja = MyYanoljaFragment()
                        supportFragmentManager.beginTransaction()
                            .add(R.id.main_frameLayout, fmMyYanolja!!)
                            .commitAllowingStateLoss()
                    }
                    if (fmHome != null) supportFragmentManager.beginTransaction().hide(fmHome!!)
                        .commitAllowingStateLoss()
                    if (fmArea != null) supportFragmentManager.beginTransaction().hide(fmArea!!)
                        .commitAllowingStateLoss()
                    if (fmMyNear != null) supportFragmentManager.beginTransaction().hide(fmMyNear!!)
                        .commitAllowingStateLoss()
                    if (fmLike != null) supportFragmentManager.beginTransaction().hide(fmLike!!)
                        .commitAllowingStateLoss()
                    if (fmMyYanolja != null) supportFragmentManager.beginTransaction()
                        .show(fmMyYanolja!!).commitAllowingStateLoss()
                }

            }
            false
        }

    }
}