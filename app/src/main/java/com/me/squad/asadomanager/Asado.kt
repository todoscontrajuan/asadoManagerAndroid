package com.me.squad.asadomanager

import java.io.Serializable
import java.util.*

data class Asado(val title: String, val attendants: List<String>, val date: Date, val location: String?, val note: String?): Serializable {
}