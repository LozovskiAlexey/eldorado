package ru.webthebestapp.eldorado_consultant.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//consumer data
@Serializable
data class ConsultationClient(
    @SerialName("consultationId") val id: Int,
    @SerialName("clientName") val name: String,
    @SerialName("tags") val tags: List<String>,
//    @SerialName("avg_price") val avg_price: Int
)
