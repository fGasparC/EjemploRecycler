package com.example.recyclerview

data class Pokemon(val nombre: String = "Sin nombre", val poder: Int=0, val tipo: String= "normal", val nivel: Int=0, var atrapado: Boolean=false) {
}