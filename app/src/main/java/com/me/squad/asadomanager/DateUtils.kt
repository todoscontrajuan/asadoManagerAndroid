package com.me.squad.asadomanager

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    @JvmStatic
    fun toSimpleString(date: Date) : String {
        val format = SimpleDateFormat("dd/MM/yy")
        return format.format(date)
    }
}