package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemContactoBinding


class ContactoAdapter (private val contactos: MutableList<Contacto>): RecyclerView.Adapter<ContactoAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_contacto,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount()= contactos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contacto=contactos.get(position)
        holder.binding.nomUsuario.text=contacto.nombre
        holder.binding.email.text=contacto.email
        holder.binding.telefono.text=contacto.telefono
        //PROBLEMA CON LA API 28. CON API 35 FUNCIONA
        //CON MATERIALIMAGESHAPEABLE FALLA CON IMAGECOMPAT FURULA.
        holder.binding.Foto.setImageResource(
            when(contacto.imagen){
                "androide" -> R.drawable.androide
                "pato3" -> R.drawable.pato3
                "androide3" ->R.drawable.androide3
                else -> R.drawable.androide
            }
        )
    }
    inner class ViewHolder (view: View): RecyclerView.ViewHolder(view){
        val binding= ItemContactoBinding.bind(view)
    }
}