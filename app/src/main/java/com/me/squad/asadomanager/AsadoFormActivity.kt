package com.me.squad.asadomanager

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_asado_form.*
import java.util.*

class AsadoFormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asado_form)

        back_button_add.setOnClickListener {finish()}

        setDateSelector()
    }

    private fun setDateSelector() {
        val cal = Calendar.getInstance()

        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            date_text_add.setText(DateUtils.toSimpleString(cal.time))
        }
        date_text_add.setOnClickListener {
            DatePickerDialog(this@AsadoFormActivity, R.style.DatePicker, dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
        }
    }
}
