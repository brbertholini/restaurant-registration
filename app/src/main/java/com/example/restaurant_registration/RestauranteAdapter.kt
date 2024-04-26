package com.example.restaurant_registration

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RestauranteAdapter(private val restaurantes: List<Restaurante>) : RecyclerView.Adapter<RestauranteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestauranteViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.restaurante_item_layout, parent, false)
        return RestauranteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RestauranteViewHolder, position: Int) {
        val restaurante = restaurantes[position]
        holder.nomeRestauranteTextView.text = restaurante.nome
        holder.tipoComidaTextView.text = restaurante.tipoComida
    }

    override fun getItemCount(): Int {
        return restaurantes.size
    }
}

