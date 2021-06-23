package ru.webthebestapp.eldorado_consultant.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConsultantStatistic(
    @SerialName("consultantId") val consultantId: Int,
    @SerialName("consultantName") val consultantName: String,
    @SerialName("totalConsultations") val totalConsultations: Int,
    @SerialName("succeededConsultations") val succeededConsultations: Int,
    @SerialName("unfinishedConsultations") val unfinishedConsultations: Int

)
