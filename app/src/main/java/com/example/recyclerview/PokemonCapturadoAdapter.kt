package com.example.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemPokemonBinding

class PokemonCapturadoAdapter(private val pokemonsCapturados: MutableList<Pokemon>, private val listener: OnClickListener) : RecyclerView.Adapter<PokemonCapturadoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = pokemonsCapturados.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemonsCapturados.get(position)
        holder.setListener(pokemon)
        holder.binding.textview.text = pokemon.nombre
        Log.v("Pokemon", pokemon.toString())
        holder.binding.checkbox.isChecked = pokemon.atrapado
        holder.binding.checkbox.setOnClickListener {
            pokemon.atrapado = holder.binding.checkbox.isChecked
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val binding = ItemPokemonBinding.bind(view)
        fun setListener(pokemon: Pokemon) {
            binding.root.setOnClickListener {
                listener.onLongClick(pokemon)
                true
            }
        }
    }

    fun addPokemonCapturado(pokemon: Pokemon) {
        pokemonsCapturados.add(pokemon)
        notifyDataSetChanged()
    }

    fun removePokemonCapturado(pokemon: Pokemon) {
        pokemonsCapturados.remove(pokemon)
        notifyDataSetChanged()
    }
}