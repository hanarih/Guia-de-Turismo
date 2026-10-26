package com.example.guia_de_turismo

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.guia_de_turismo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var destinos: List<Destino>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()
        setupViews()
        setupListeners()
    }

    fun loadData(){
        destinos = listOf(
            Destino(
                R.drawable.sp,
                "São Paulo",
                "Capital financeira e cultural",
                "Pacote 3 dias / 2 noites",
                "Hotel Grand Mercure",
                "(11) 3000-1111",
                "geo:0,0?q=Avenida+Paulista+Sao+Paulo"
            ),
            Destino(
                R.drawable.rj,
                "Rio de Janeiro",
                "Cidade Maravilhosa",
                "Pacote 5 dias com tour",
                "Hotel Copacabana Palace",
                "(21) 3000-2222",
                "geo:0,0?q=Cristo+Redentor+Rio+de+Janeiro"
            ),
            Destino(
                R.drawable.sal,
                "Salvador",
                "História e praias",
                "Pacote 4 dias",
                "História e praias",
                "(71) 3000-3333",
                "geo:0,0?q=Pelourinho+Salvador"
            ),
            Destino(
                R.drawable.foz,
                "Foz do Iguaçu",
                "Cataratas do Iguaçu",
                "Pacote 4 dias com ingressos",
                "Hotel Belmond das Cataratas",
                "(45) 3000-4444",
                "geo:0,0?q=Cataratas+do+Iguacu"
            ),
            Destino(
                R.drawable.gra,
                "Gramado",
                "Charme serrano",
                "Pacote 4 dias com passeios",
                "Hotel Wish Serrano",
                "(54) 3000-5555",
                "geo:0,0?q=Gramado+RS"
            ) ,
            Destino(
                R.drawable.flori,
                "Florianópolis",
                "A Ilha da Magia",
                "Pacote 6 dias com lancha",
                "Hotel Majestic Palace",
                "(48) 3000-6666",
                "geo:0,0?q=Florianopolis"
            ),
            Destino(
                R.drawable.reci,
                "Recife",
                "Cultura e frevo",
                "Pacote 5 dias com passeios",
                "Hotel Atlante Plaza",
                "(81) 3000-7777",
                "geo:0,0?q=Olinda"
            ),
            Destino(
                R.drawable.manaus,
                "Manaus",
                "Floresta Amazônica",
                "Pacote 4 dias eco-tour",
                "Juma Amazon Lodge",
                "(92) 3000-8888",
                "geo:0,0?q=Teatro+Amazonas+Manaus"
            ),
            Destino
                (R.drawable.bh,
                "Belo Horizonte",
                "Gastronomia mineira",
                "Pacote 3 dias com Inhotim",
                "Hotel Mercure Lourdes",
                "(31) 3000-9999",
                "geo:0,0?q=Praca+da+Liberdade+BH"
            ),
            Destino(
                R.drawable.bonito,
                "Bonito",
                "Ecoturismo e grutas",
                "Pacote 5 dias com flutuação",
                "Zagaia Eco Resort",
                "(67) 3000-0000",
                "geo:0,0?q=Bonito+MS"
            )
        ).sortedBy { it.nome }
    }
    fun setupViews(){
        val adapter = DestinoAdapter(this, destinos)
        binding.listViewDestinos.adapter = adapter
    }
    fun setupListeners(){
        binding.listViewDestinos.setOnItemClickListener { _, _, position, _ ->
            val destino = destinos[position]
            val intent = Intent(this, DetalhesActivity::class.java).apply{
                putExtra("destino", destino)
            }
            startActivity(intent)
        }

    }
}
