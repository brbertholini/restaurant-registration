package com.example.restaurant_registration

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListagemActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var listaRestaurantes: ArrayList<Restaurante>

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.listagem_activity)

        listView = findViewById(R.id.listView)

        // Obter a lista de restaurantes da intent
        listaRestaurantes = intent.<Restaurante>("restaurantes") ?: ArrayList()

        // Configurar o adaptador para o ListView
        val adapter = RestauranteAdapter(this, listaRestaurantes)
        listView.adapter = adapter
    }
}


