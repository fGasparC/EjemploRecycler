package com.example.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityEjercicio1Binding

class Ejercicio1 : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio1Binding
    private lateinit var adapContacto: ContactoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityEjercicio1Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val and1="androide"
        val and2="pato3"
        val and3="androide3"
        val data= mutableListOf(
            Contacto("Peptio","a@email.com","666555444", and1),
            Contacto("Peptio","aa@email.com","666555444", and2),
            Contacto("Peptio","aaa@email.com","666555444", and3),
            Contacto("Peptio","aaaa@email.com","666555444", and1),
            Contacto("Peptio","aaasdf@email.com","666555444", and2),
            Contacto("Peptio","asdafas@email.com","666555444", and3),
            Contacto("Peptio","bbb@email.com","666555444", and1),
            Contacto("Peptio","bbba@email.com","666555444", and2),
            Contacto("Peptio","afdsa@email.com","666555444", and3),
            Contacto("Ptio","aasdf@email.com","666555444", and2),
            Contacto("Peptio","a@email.com","666555444", and2),
            Contacto("Peptio","a@email.com","666555444", and2),
            Contacto("Peptio","a@email.com","666555444", and2),
            Contacto("Peptio","a@email.com","666555444", and2),
            Contacto("Peptio","a@email.com","666555444", and2),
            Contacto("Peptio","a@email.com","666555444", and2),
            Contacto("Peptio","a@email.com","666555444", and2),
            Contacto("Peptio","a@email.com","666555444", and2),
            Contacto("Peptio","a@email.com","666555444", and2),
            Contacto("Peptio","a@email.com","666555444", and2)
        )
        adapContacto= ContactoAdapter(data)
        binding.reclyclerView.apply{
            layoutManager=LinearLayoutManager(this@Ejercicio1)
            adapter=adapContacto
        }
    }
}