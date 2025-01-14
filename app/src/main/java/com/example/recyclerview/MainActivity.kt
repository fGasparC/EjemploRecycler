package com.example.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pokemonAdapter: PokemonAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val data= mutableListOf(
            Pokemon("Pokemoncito1",100,"marronero",10),
            Pokemon("Pokemoncito2",100,"marronero",10),
            Pokemon("Pokemoncito3",100,"marronero",10),
            Pokemon("Pokemoncito4",100,"marronero",10),
            Pokemon("Pokemoncito5",100,"marronero",10),
            Pokemon("Pokemoncito6",100,"marronero",10),
            Pokemon("Pokemoncito7",100,"marronero",10),
            Pokemon("Pokemoncito8",100,"marronero",10),
            Pokemon("Pokemoncito9",100,"marronero",10),
            Pokemon("Pokemoncito10",100,"marronero",10),
            Pokemon("Pokemoncito11",100,"marronero",10),
            Pokemon("Pokemoncito12",100,"marronero",10),
            Pokemon("Pokemoncito13",100,"marronero",10),
            Pokemon("Pokemoncito14",100,"marronero",10),
            Pokemon("Pokemoncito15",100,"marronero",10),
            Pokemon("Pokemoncito16",100,"marronero",10),
            Pokemon("Pokemoncito10",100,"marronero",10),
            Pokemon("Pokemoncito20",100,"marronero",10),
            Pokemon("Pokemoncito30",100,"marronero",10),
            Pokemon("Pokemoncito40",100,"marronero",10),
            Pokemon("Pokemoncito50",100,"marronero",10),
            Pokemon("Pokemoncito60",100,"marronero",10),
            Pokemon("Pokemoncito70",100,"marronero",10),
            Pokemon("Pokemoncito80",100,"marronero",10),
            Pokemon("Pokemoncito90",1000,"marronero",10),
            Pokemon("Pokemoncito100",1000,"marronero",10),
            Pokemon("Pokemoncito110",1000,"marronero",10),
            Pokemon("Pokemoncito120",1000,"marronero",10),
            Pokemon("Pokemoncito130",1000,"marronero",10),
            Pokemon("Pokemoncito140",1000,"marronero",10),
            Pokemon("Pokemoncito150",1000,"marronero",10),
            Pokemon("Pokemoncito16",1000,"marronero",10)
        )
        pokemonAdapter=PokemonAdapter(data,this)
        binding.reclyclerView.apply{
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter=pokemonAdapter
        }
    }

    override fun onLongClick(pokemon: Pokemon) {
        TODO("Not yet implemented")
    }
}