package com.example.guia_de_turismo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.example.guia_de_turismo.databinding.ActivityDetalhesBinding
import com.example.guia_de_turismo.Destino

class DetalhesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesBinding
    private lateinit var destino: Destino

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()
        setupViews()
        setupListeners()
    }

    private fun loadData() {
        destino = intent.getSerializableExtra("destino") as Destino
    }

    private fun setupListeners() {
        binding.tvTelefone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = "tel:${destino.telefone}".toUri()
            startActivity(intent)
        }
        binding.btnComoChegar.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = destino.enderecoMaps.toUri()
            startActivity(intent)
        }
        binding.btnEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = "mailto:contato@ifsp.edu.br".toUri()
            startActivity(intent)
        }
        binding.btnVoltar.setOnClickListener {
           finish()
        }
    }

    private fun setupViews(){
        binding.tvNome.text = destino.nome
        binding.tvDescricao.text = destino.descricao
        binding.tvPacote.text = destino.pacote
        binding.tvHotel.text = destino.hotel
        binding.tvTelefone.text = destino.telefone
        binding.imgFoto.setImageResource(destino.foto)
    }
}

