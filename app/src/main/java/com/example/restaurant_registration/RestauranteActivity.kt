package com.example.restaurant_registration

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RestauranteActivity : AppCompatActivity() {

    var listaRestaurantes = ArrayList<Restaurante>()

    override fun onCreate(bundle : Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.cadastro_restaurante_activity)

        val txtNomeRestaurante = findViewById<EditText>(R.id.edtRestaurante)
        val txtEndereco = findViewById<EditText>(R.id.edtEndereco)
        val txtTipoComida = findViewById<EditText>(R.id.edtTipoComida)
        val txtClassificacao = findViewById<EditText>(R.id.edtClassificacao)
        val txtLatitude = findViewById<EditText>(R.id.edtLatitude)
        val txtLongitude = findViewById<EditText>(R.id.edtLongitude)
        val txtDescricao = findViewById<EditText>(R.id.edtDescricao)

        val btnGravar = findViewById<Button>(R.id.buttonGravar)
        val btnLista = findViewById<Button>(R.id.buttonLista)

        btnGravar.setOnClickListener {
            val nome = txtNomeRestaurante.text.toString()
            val endereco = txtEndereco.text.toString()
            val tipoComida = txtTipoComida.text.toString()
            val classificacao = txtClassificacao.text.toString().toIntOrNull() ?: 0
            val latitude = txtLatitude.text.toString().toDoubleOrNull() ?: 0.0
            val longitude = txtLongitude.text.toString().toDoubleOrNull() ?: 0.0
            val descricao = txtDescricao.text.toString()

            val restaurante = Restaurante(
                id = 0,
                nome = nome,
                endereco = endereco,
                latitude = latitude,
                longitude = longitude,
                tipoComida = tipoComida,
                classificacao = classificacao,
                descricao = descricao
            )

            print(restaurante)
            listaRestaurantes.add(restaurante)

            salvarPrefs()
        }

        btnLista.setOnClickListener {
            carregarPrefs()

            val intent = Intent(this@RestauranteActivity, ListagemActivity::class.java)
            intent.putExtra("restaurantes", listaRestaurantes)
            startActivity(intent)
        }
    }

    private fun salvarPrefs() {
        val sharedPreferences: SharedPreferences = getSharedPreferences("restaurantes_prefs", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        val gson = Gson()
        val json = gson.toJson(listaRestaurantes)
        editor.putString("restaurantes", json)
        editor.apply()
    }

    private fun carregarPrefs() {
        val sharedPreferences: SharedPreferences = getSharedPreferences("restaurantes_prefs", Context.MODE_PRIVATE)
        val json = sharedPreferences.getString("restaurantes", null)

        val gson = Gson()
        val type = object : TypeToken<List<Restaurante>>() {}.type
        listaRestaurantes = gson.fromJson(json, type) ?: ArrayList()
    }

}