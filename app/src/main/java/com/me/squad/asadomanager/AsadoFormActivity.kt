package com.me.squad.asadomanager

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_asado_form.*
import java.util.*

class AsadoFormActivity : AppCompatActivity() {

    private val cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asado_form)
        back_button_add.setOnClickListener {finish()}

        setDateSelector()
        setTimeSelector()
    }

    private fun setDateSelector() {
        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            date_text_add.setText(DateUtils.toSimpleString(cal.time))
        }
        date_text_add.setOnClickListener {
            DatePickerDialog(this@AsadoFormActivity, R.style.PickerTheme, dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

    private fun setTimeSelector() {
        val timeSetListener = TimePickerDialog.OnTimeSetListener { _, hours, minute ->
            time_text_add.setText(DateUtils.toSimpleStringTime(hours, minute))
        }
        time_text_add.setOnClickListener {
            TimePickerDialog(this@AsadoFormActivity, R.style.PickerTheme, timeSetListener,
                    cal.get(Calendar.HOUR_OF_DAY),
                    cal.get(Calendar.MINUTE),
                    false).show()
        }
    }
}
