package com.randel.agroguard.repository

import com.randel.agroguard.Data.Model.Ocorrencia
import com.randel.agroguard.Network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OcorrenciaRepository {

    // Get all Ocorrencias
    fun getAllOcorrencias(): Call<List<Ocorrencia>> {
        return RetrofitInstance.api.getAllOcorrencias()
    }

    // Get an Ocorrencia by ID
    fun getOcorrenciaById(id: Int): Call<Ocorrencia> {
        return RetrofitInstance.api.getOcorrenciaById(id)
    }

    // Create a new Ocorrencia
    fun createOcorrencia(ocorrencia: Ocorrencia): Call<Ocorrencia> {
        return RetrofitInstance.api.createOcorrencia(ocorrencia)
    }

    // Update an existing Ocorrencia
    fun updateOcorrencia(id: Int, ocorrencia: Ocorrencia): Call<Ocorrencia> {
        return RetrofitInstance.api.updateOcorrencia(id, ocorrencia)
    }

    // Delete an Ocorrencia by ID
    fun deleteOcorrencia(id: Int): Call<Void> {
        return RetrofitInstance.api.deleteOcorrencia(id)
    }
}
