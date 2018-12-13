package com.me.squad.asadomanager

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.asados_item_row.view.*
import java.util.*

class AsadosAdapter(private val asados: ArrayList<Asado>, private val context: Context): RecyclerView.Adapter<AsadosAdapter.AsadoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsadosAdapter.AsadoHolder {
        val inflatedView = parent.inflate(R.layout.asados_item_row, false)
        return AsadoHolder(inflatedView, context)
    }

    override fun getItemCount() = asados.size

    override fun onBindViewHolder(holder: AsadosAdapter.AsadoHolder, position: Int) {
        val itemAsado = asados[position]
        holder.bindAsado(itemAsado)
    }

    class AsadoHolder(v: View, val context: Context): RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private var asado: Asado? = null

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val intent = Intent(context, EditAsadoFormActivity::class.java)
            intent.putExtra("Asado", asado)
            context.startActivity(intent)
        }

        fun bindAsado(asado: Asado) {
            this.asado = asado
            view.asado_title.text = asado.title
            view.asado_attendants.text = asado.attendants.size.toString() + " asistentes"
            view.asado_date.text = DateUtils.toSimpleString(asado.date)
        }

    }
}