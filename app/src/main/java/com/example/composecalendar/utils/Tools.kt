package com.example.composecalendar.utils

import android.util.Log
import java.util.*
import java.util.Set.of

object Tools {
    fun debugMwssage(message:String, tag:String="DEBUG-MESSAGE"){
        Log.e(tag, message)
    }

    fun getDateRange(): Pair<List<String>, List<String>> {
        var begining: Date
        var end: Date
        run {
            val calendar: Calendar = getCalendarForNow()
            calendar.set(
                Calendar.DAY_OF_MONTH,
                calendar.getActualMinimum(Calendar.DAY_OF_MONTH)
            )
            setTimeToBeginningOfDay(calendar)
            begining = calendar.time
        }
        run {
            val calendar: Calendar = getCalendarForNow()
            calendar.set(
                Calendar.DAY_OF_MONTH,
                calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
            )
            setTimeToEndofDay(calendar)
            end = calendar.time
        }
        return Pair(begining.toString().split(" "), end.toString().split(" "))
    }

    private fun getCalendarForNow(): Calendar {
        val calendar = GregorianCalendar.getInstance()
        calendar.time = Date()
        return calendar
    }

    private fun setTimeToBeginningOfDay(calendar: Calendar) {
        calendar[Calendar.HOUR_OF_DAY] = 0
        calendar[Calendar.MINUTE] = 0
        calendar[Calendar.SECOND] = 0
        calendar[Calendar.MILLISECOND] = 0
    }

    private fun setTimeToEndofDay(calendar: Calendar) {
        calendar[Calendar.HOUR_OF_DAY] = 23
        calendar[Calendar.MINUTE] = 59
        calendar[Calendar.SECOND] = 59
        calendar[Calendar.MILLISECOND] = 999
    }
}