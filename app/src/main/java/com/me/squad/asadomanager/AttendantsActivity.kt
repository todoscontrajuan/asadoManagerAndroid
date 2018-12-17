package com.me.squad.asadomanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_attendants.*

class AttendantsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendants)

        val attendants = mutableListOf<String>("Asistente 1", "Asistente 2", "Asistente 3")
        for (item: String in attendants) {
            val textView = TextView(this)
            textView.setTextColor(resources.getColor(R.color.colorPrimaryDark))
            textView.textSize = resources.getDimension(R.dimen.list_text_size)
            textView.text = item
            textView.layoutParams = ViewGroup.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            attendants_list.addView(textView)
        }
    }
}
