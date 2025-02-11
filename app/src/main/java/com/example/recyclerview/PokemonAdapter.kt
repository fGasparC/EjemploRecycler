package com.example.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemPokemonBinding

class PokemonAdapter(private val pokemons: MutableList<Pokemon>, private val listener: OnClickListener, private val listener2: CheckSelected) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount()= pokemons.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon= pokemons.get(position)
        holder.setListener(pokemon)
        holder.binding.textview.text=pokemon.nombre
        Log.v("Pokemon",pokemon.toString())
        holder.binding.checkbox.isChecked=pokemon.atrapado
        holder.binding.checkbox.setOnClickListener{
            pokemon.atrapado=holder.binding.checkbox.isChecked
            Log.d("PokemonAdapter", "isChecked: Pokémon ${pokemon.nombre} ahora está atrapado: ${pokemon.atrapado}")
            holder.isChecked(pokemon)
            listener2.onPokemonSelected(pokemon)
        }
    }

    inner class ViewHolder (view: View): RecyclerView.ViewHolder(view){

        val binding=ItemPokemonBinding.bind(view)
        fun setListener(pokemon:Pokemon){
            binding.root.setOnClickListener {
                listener.onLongClick(pokemon)
                true
            }
        }
        fun isChecked(pokemon:Pokemon):Boolean{
            Log.d("PokemonAdapter2", "isChecked: Pokémon ${pokemon.nombre} ahora está atrapado: ${pokemon.atrapado}")
            return pokemon.atrapado
        }
    }
    fun addPokemon(pokemon:Pokemon){
        pokemons.add(pokemon)
        notifyDataSetChanged()
    }
    fun removePokemon(pokemon:Pokemon){
        pokemons.remove(pokemon)
        notifyDataSetChanged()
    }
}