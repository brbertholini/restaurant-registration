package com.example.restaurant_registration

import android.os.Parcel
import android.os.Parcelable

data class Restaurante(
    val id: Long,
    val nome: String,
    val endereco: String,
    val latitude: Double,
    val longitude: Double,
    val tipoComida: String,
    val classificacao: Int,
    val descricao: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(nome)
        parcel.writeString(endereco)
        parcel.writeDouble(latitude)
        parcel.writeDouble(longitude)
        parcel.writeString(tipoComida)
        parcel.writeInt(classificacao)
        parcel.writeString(descricao)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Restaurante> {
        override fun createFromParcel(parcel: Parcel): Restaurante {
            return Restaurante(parcel)
        }

        override fun newArray(size: Int): Array<Restaurante?> {
            return arrayOfNulls(size)
        }
    }
}
