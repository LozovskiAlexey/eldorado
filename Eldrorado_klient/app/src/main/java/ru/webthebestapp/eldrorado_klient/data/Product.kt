package ru.webthebestapp.eldrorado_klient.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Product(
    @SerialName("name") val name: String,
    @SerialName("image") val image: String,
    @SerialName("price") val price: Int,
    @SerialName("amount") val amount: Int,
//    @SerialName("category") val category: String
)
