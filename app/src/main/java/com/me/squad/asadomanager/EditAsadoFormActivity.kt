package com.me.squad.asadomanager

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_asado_form.*
import java.util.*

class EditAsadoFormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_asado_form)
        back_button_edit.setOnClickListener {finish()}

        setupUI()
        setDateSelector()
    }

    private fun setupUI() {
        var asado = intent.getSerializableExtra("Asado")
        asado = asado as Asado
        asado_title_edit.setText(asado.title)
        date_text_edit.setText(DateUtils.toSimpleString(asado.date))
        location_text_edit.setText(asado.location)
        note_text_edit.setText(asado.note)
    }

    private fun setDateSelector() {
        val cal = Calendar.getInstance()

        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            date_text_edit.setText(DateUtils.toSimpleString(cal.time))
        }
        date_text_edit.setOnClickListener {
            DatePickerDialog(this@EditAsadoFormActivity, R.style.DatePicker, dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
        }
    }
}
