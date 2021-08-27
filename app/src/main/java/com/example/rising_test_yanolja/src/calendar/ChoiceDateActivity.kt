package com.example.rising_test_yanolja.src.calendar

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.get
import com.applikeysolutions.cosmocalendar.selection.OnDaySelectedListener
import com.applikeysolutions.cosmocalendar.selection.RangeSelectionManager
import com.example.rising_test_yanolja.config.BaseActivity
import com.example.rising_test_yanolja.databinding.ActivityChoiceDateBinding
import java.text.SimpleDateFormat
import java.util.*

class ChoiceDateActivity :
    BaseActivity<ActivityChoiceDateBinding>(ActivityChoiceDateBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var checkInDate=""
        var checkOutDate=""
        var firstMonth = ""
        var lastMonth = ""
        var firstLongDate=""
        var lastLongDate=""
        var firstToday = ""
        var lastToday =""
        var firstDate= 0
        var lastDate = 0
        binding.calendar.selectionManager = RangeSelectionManager(OnDaySelectedListener {
//            var days = binding.calendar.selectedDays
//            var day : Int
//            println(days[0].dayNumber)
//            println(days[0])



            Log.e(" CALENDAR ", "========== setSelectionManager ==========")
            Log.e(" CALENDAR ", "Selected Dates : " + binding.calendar.selectedDates.size)
            if (binding.calendar.selectedDates.size <= 0) return@OnDaySelectedListener
            Log.e(" CALENDAR ", "Selected Days : " + binding.calendar.selectedDays)



            var day = binding.calendar.selectedDays.toString().split(", ")
            var firstDay = day[0]
            var lastDay = day[day.size - 1]

            firstDate= binding.calendar.selectedDays[0].dayNumber
            lastDate = binding.calendar.selectedDays[day.size-1].dayNumber

            if (firstDay.contains("Aug"))
                firstMonth = "8"
            else if (firstDay.contains("Sep"))
                firstMonth = "9"
            else if (firstDay.contains("Oct"))
                firstMonth = "10"
            else
                firstMonth ="11"

            if (lastDay.contains("Aug"))
                lastMonth = "8"
            else if (firstDay.contains("Sep"))
                lastMonth = "9"
            else if (lastDay.contains("Oct"))
                lastMonth = "10"
            else
                lastMonth="11"

            if(firstDate>9){
                firstLongDate = "20210${firstMonth}${firstDate}"
                checkInDate="2021-${firstMonth}-${firstDate}"
            }else{
                firstLongDate = "20210${firstMonth}0${firstDate}"
                checkInDate="2021-${firstMonth}-0${firstDate}"
            }


            if(lastDate>9){
                lastLongDate = "20210${lastMonth}${lastDate}"
                checkOutDate="2021-${lastMonth}-${lastDate}"
            }else{
                lastLongDate = "20210${firstMonth}0${lastDate}"
                checkOutDate="2021-${lastMonth}-0${lastDate}"
            }

            firstToday = getDateDay(firstLongDate,"yyyyMMdd").toString()
            lastToday = getDateDay(lastLongDate,"yyyyMMdd").toString()


            if(day.size>1){
                binding.btnOk.text="${firstMonth}월${firstDate}일(${firstToday})~${lastMonth}월${lastDate}일(${lastToday})\u00b7${day.size}박"
            }else{
                binding.btnOk.text="${firstMonth}월${firstDate}일(${firstToday}) 체크인 검색"
            }
        })



        binding.btnOk.setOnClickListener {
            var resultIntent = Intent()
            resultIntent.putExtra("checkInDate",checkInDate)
            resultIntent.putExtra("checkOutDate",checkOutDate)
            resultIntent.putExtra("firstMonth",firstMonth)
            resultIntent.putExtra("firstDate",firstDate.toString())
            resultIntent.putExtra("lastMonth",lastMonth)
            resultIntent.putExtra("lastDate",lastDate.toString())
            resultIntent.putExtra("firstToday",firstToday)
            resultIntent.putExtra("lastToday",lastToday)
            setResult(Activity.RESULT_OK,resultIntent)
            finish()
        }
    }


    @Throws(Exception::class)
    fun getDateDay(date: String, dateType: String?): String? {
        var changeDate = ""
        var splitResult = date.split("-")
        for(i in splitResult){
            changeDate+=i
        }
        var day = ""
        val dateFormat = SimpleDateFormat(dateType)
        val nDate: Date = dateFormat.parse(changeDate)
        val cal: Calendar = Calendar.getInstance()
        cal.setTime(nDate)
        val dayNum: Int = cal.get(Calendar.DAY_OF_WEEK)
        when (dayNum) {
            1 -> day = "일"
            2 -> day = "월"
            3 -> day = "화"
            4 -> day = "수"
            5 -> day = "목"
            6 -> day = "금"
            7 -> day = "토"
        }
        return day
    }
}