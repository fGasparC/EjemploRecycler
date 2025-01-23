package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemContactoBinding
import com.example.recyclerview.databinding.ItemPiezaBinding

class PiezaAdapter(private val piezas: MutableList<Pieza>): RecyclerView.Adapter<PiezaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_pieza,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount()= piezas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val pieza=piezas.get(position)
        holder.binding.nomPieza.text=pieza.nomPieza
        holder.binding.imgPieza.setImageResource(
            when(pieza.imagen){
                "torre" -> R.drawable.torre
                "rey" -> R.drawable.rey
                "reina" ->R.drawable.reina
                "alfil" ->R.drawable.alfil
                "caballo"->R.drawable.caballo
                else -> R.drawable.peon
            }
        )
    }
    inner class ViewHolder (view: View): RecyclerView.ViewHolder(view){
        val binding= ItemPiezaBinding.bind(view)
    }
}
