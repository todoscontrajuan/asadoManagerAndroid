package com.me.squad.asadomanager

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.asados_item_row.view.*

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
            Log.d("RecyclerView", "CLICK! ${asado}")
            val intent = Intent(context, EditAsadoFormActivity::class.java)
            context.startActivity(intent)
        }

        fun bindAsado(asado: Asado) {
            this.asado = asado
            view.asado_title.text = asado.title
            view.asado_invites.text = asado.invites.toString() + " asistentes"
            view.asado_date.text = asado.date
        }

    }
}