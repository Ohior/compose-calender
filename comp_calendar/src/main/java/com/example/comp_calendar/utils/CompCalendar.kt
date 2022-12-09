package com.example.comp_calendar.utils

import java.util.*

object CompCalendar {
    val DAYS_OF_WEEKS = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")

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
        val beginList = begining.toString().split(" ")
        val endList = end.toString().split(" ")
        val beginMap = mapOf(
            Pair("day", beginList[0]),
            Pair("month", beginList[1]),
            Pair("dayDate", beginList[2]),
            Pair("time", beginList[3]),
            Pair("gmt", beginList[4]),
            Pair("year", beginList[5]),
        )
        val lastMap = mapOf(
            Pair("day", endList[0]),
            Pair("month", endList[1]),
            Pair("dayDate", endList[2]),
            Pair("time", endList[3]),
            Pair("gmt", endList[4]),
            Pair("year", endList[5]),
        )
        return Pair(beginList, endList)
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