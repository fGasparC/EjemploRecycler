package com.example.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityEjercicio1Binding
import com.example.recyclerview.databinding.ActivityEjercicio2Binding

class Ejercicio2 : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio2Binding
    private lateinit var adapPieza: PiezaAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityEjercicio2Binding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val data= mutableListOf(
            Pieza("LA TORRE","torre"),
            Pieza("EL ALFIL","alfil"),
            Pieza("LA REINA","reina"),
            Pieza("EL REY","rey"),
            Pieza("EL PEON","peon"),
            Pieza("EL CABALLO","caballo")
        )
        adapPieza= PiezaAdapter(data)
        binding.reclyclerView.apply{
            layoutManager= LinearLayoutManager(this@Ejercicio2,LinearLayoutManager.HORIZONTAL,false)
            adapter=adapPieza
        }
    }
}