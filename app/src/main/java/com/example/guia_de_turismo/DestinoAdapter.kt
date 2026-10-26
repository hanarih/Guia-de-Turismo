package com.example.guia_de_turismo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class DestinoAdapter(
    private val context: Context,
    private val lista: List<Destino>
) : ArrayAdapter<Destino>(context, 0, lista) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.destino, parent, false)

        val destino = lista[position]

        val imgFoto = itemView.findViewById<ImageView>(R.id.imgFoto)
        val tvNome = itemView.findViewById<TextView>(R.id.tvNome)
        val tvDescricao = itemView.findViewById<TextView>(R.id.tvDescricao)

        imgFoto.setImageResource(destino.foto)
        tvNome.text = destino.nome
        tvDescricao.text = destino.descricao

        return itemView
    }
}