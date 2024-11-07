package com.randel.agroguard.Viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.randel.agroguard.Data.Model.Tecnico
import com.randel.agroguard.repository.TecnicoRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TecnicoViewModel : ViewModel() {
    private val repository = TecnicoRepository()

    val tecnicosLiveData = MutableLiveData<List<Tecnico>>()
    val tecnicoLiveData = MutableLiveData<Tecnico>()
    val messageLiveData = MutableLiveData<String>()

    // Fetch all Tecnicos
    fun fetchAllTecnicos() {
        repository.getAllTecnicos().enqueue(object : Callback<List<Tecnico>> {
            override fun onResponse(call: Call<List<Tecnico>>, response: Response<List<Tecnico>>) {
                if (response.isSuccessful) {
                    tecnicosLiveData.postValue(response.body())
                } else {
                    messageLiveData.postValue("Failed to load tecnicos.")
                }
            }

            override fun onFailure(call: Call<List<Tecnico>>, t: Throwable) {
                messageLiveData.postValue("Error: ${t.message}")
            }
        })
    }

    // Fetch a single Tecnico by ID
    fun fetchTecnicoById(id: Int) {
        repository.getTecnicoById(id).enqueue(object : Callback<Tecnico> {
            override fun onResponse(call: Call<Tecnico>, response: Response<Tecnico>) {
                if (response.isSuccessful) {
                    tecnicoLiveData.postValue(response.body())
                } else {
                    messageLiveData.postValue("Failed to load tecnico.")
                }
            }

            override fun onFailure(call: Call<Tecnico>, t: Throwable) {
                messageLiveData.postValue("Error: ${t.message}")
            }
        })
    }

    // Add a new Tecnico
    fun addTecnico(tecnico: Tecnico) {
        repository.createTecnico(tecnico).enqueue(object : Callback<Tecnico> {
            override fun onResponse(call: Call<Tecnico>, response: Response<Tecnico>) {
                if (response.isSuccessful) {
                    fetchAllTecnicos()  // Refresh the list
                    messageLiveData.postValue("Tecnico created successfully")
                } else {
                    messageLiveData.postValue("Error creating tecnico.")
                }
            }

            override fun onFailure(call: Call<Tecnico>, t: Throwable) {
                messageLiveData.postValue("Error: ${t.message}")
            }
        })
    }

    // Update an existing Tecnico
    fun updateTecnico(id: Int, tecnico: Tecnico) {
        repository.updateTecnico(id, tecnico).enqueue(object : Callback<Tecnico> {
            override fun onResponse(call: Call<Tecnico>, response: Response<Tecnico>) {
                if (response.isSuccessful) {
                    fetchAllTecnicos()  // Refresh the list
                    messageLiveData.postValue("Tecnico updated successfully")
                } else {
                    messageLiveData.postValue("Error updating tecnico.")
                }
            }

            override fun onFailure(call: Call<Tecnico>, t: Throwable) {
                messageLiveData.postValue("Error: ${t.message}")
            }
        })
    }

    // Delete a Tecnico by ID
    fun deleteTecnico(id: Int) {
        repository.deleteTecnico(id).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    fetchAllTecnicos()  // Refresh the list
                    messageLiveData.postValue("Tecnico deleted successfully")
                } else {
                    messageLiveData.postValue("Error deleting tecnico.")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                messageLiveData.postValue("Error: ${t.message}")
            }
        })
    }
}
