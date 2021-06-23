package ru.webthebestapp.eldorado_consultant.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Basket(
    //id, amount
    @SerialName("products") val products: Map<Int, Int>
)
