package com.example.guia_de_turismo

import java.io.Serializable

data class Destino (
    val foto: Int,
    val nome: String,
    val descricao: String,
    val pacote: String,
    val hotel: String,
    val telefone: String,
    val enderecoMaps: String
) : Serializable