package com.randel.agroguard.Data.Model

data class Ocorrencia(
    val id: Int,
    val hectares: Int,
    val hectaresAfetados: Int,
    val cultura: String,
    val latitude: Float,
    val longitude: Float,
    val fotoOcorrencia: String ,
)