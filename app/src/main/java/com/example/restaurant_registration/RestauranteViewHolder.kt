package com.example.restaurant_registration

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestauranteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val nomeRestauranteTextView: TextView = itemView.findViewById(R.id.textNomeRestaurante)
    val tipoComidaTextView: TextView = itemView.findViewById(R.id.textTipoComida)
}
