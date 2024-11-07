package com.randel.agroguard.repository

import com.randel.agroguard.Data.Model.Tecnico
import com.randel.agroguard.Network.RetrofitInstance
import retrofit2.Call

class TecnicoRepository {

    private val apiService = RetrofitInstance.api

    // Fetch all Tecnicos
    fun getAllTecnicos(): Call<List<Tecnico>> {
        return apiService.getAllTecnicos()
    }

    // Fetch a single Tecnico by ID
    fun getTecnicoById(id: Int): Call<Tecnico> {
        return apiService.getTecnicoById(id)
    }

    // Add a new Tecnico
    fun createTecnico(tecnico: Tecnico): Call<Tecnico> {
        return apiService.createTecnico(tecnico)
    }

    // Update an existing Tecnico
    fun updateTecnico(id: Int, tecnico: Tecnico): Call<Tecnico> {
        return apiService.updateTecnico(id, tecnico)
    }

    // Delete a Tecnico by ID
    fun deleteTecnico(id: Int): Call<Void> {
        return apiService.deleteTecnico(id)
    }
}
