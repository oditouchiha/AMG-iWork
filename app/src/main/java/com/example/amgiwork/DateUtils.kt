package com.example.amgiwork

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs

class DateUtils {
    fun isDateInCurrentWeek(date: Date): Boolean {
        val currentCalendar = Calendar.getInstance()
        val week = currentCalendar.get(Calendar.WEEK_OF_YEAR)
        val year = currentCalendar.get(Calendar.YEAR)

        val targetCalendar = Calendar.getInstance()
        targetCalendar.time = date
        val targetWeek = targetCalendar.get(Calendar.WEEK_OF_YEAR)
        val targetYear = targetCalendar.get(Calendar.YEAR)

        return week == targetWeek && year == targetYear
    }

    fun getNearestDate(dates: List<Date>): Date? {
        val currentCalendar = Calendar.getInstance()
        currentCalendar.set(Calendar.MONTH, currentCalendar.get(Calendar.MONTH) + 1)
        val currentmillis = currentCalendar.timeInMillis

        return Collections.min(dates) { d1, d2 ->
            val diff1 = abs(d1.time - currentmillis)
            val diff2 = abs(d2.time - currentmillis)

            diff1.compareTo(diff2)
        }
    }

    fun stringsToDate(strdates: List<String>): MutableList<Date> {
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val dates = mutableListOf<Date>()
        for (strdate in strdates) {
            try {
                dates.add(format.parse(strdate)!!)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
        }
        return dates
    }
}