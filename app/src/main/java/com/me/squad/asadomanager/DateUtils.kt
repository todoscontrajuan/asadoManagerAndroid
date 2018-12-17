package com.me.squad.asadomanager

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    @JvmStatic
    fun toSimpleString(date: Date) : String {
        val format = SimpleDateFormat("dd/MM/yy")
        return format.format(date)
    }

    @JvmStatic
    fun toSimpleStringTime(hours: Int, minute: Int) : String {
        val suffix: String = if (hours < 12) "a.m." else "p.m."
        val auxHours = if (hours < 13) hours else hours - 12
        val formatHour: String = if (auxHours < 10) "0$auxHours" else auxHours.toString()
        val formatMinute: String = if (minute < 10) "0$minute" else minute.toString()
        return String.format("%s:%s %s", formatHour, formatMinute, suffix)
    }
}