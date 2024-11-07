package com.randel.agroguard.Viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.randel.agroguard.Data.Model.Ocorrencia
import com.randel.agroguard.repository.OcorrenciaRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OcorrenciaViewModel : ViewModel() {
    private val repository = OcorrenciaRepository()

    val ocorrenciasLiveData = MutableLiveData<List<Ocorrencia>>()
    val ocorrenciaLiveData = MutableLiveData<Ocorrencia>()
    val messageLiveData = MutableLiveData<String>()

    // Fetch all Ocorrencias
    fun fetchAllOcorrencias() {
        repository.getAllOcorrencias().enqueue(object : Callback<List<Ocorrencia>> {
            override fun onResponse(call: Call<List<Ocorrencia>>, response: Response<List<Ocorrencia>>) {
                if (response.isSuccessful) {
                    ocorrenciasLiveData.postValue(response.body())
                } else {
                    messageLiveData.postValue("Failed to load ocorrencias.")
                }
            }

            override fun onFailure(call: Call<List<Ocorrencia>>, t: Throwable) {
                messageLiveData.postValue("Error: ${t.message}")
            }
        })
    }

    // Fetch a single Ocorrencia by ID
    fun fetchOcorrenciaById(id: Int) {
        repository.getOcorrenciaById(id).enqueue(object : Callback<Ocorrencia> {
            override fun onResponse(call: Call<Ocorrencia>, response: Response<Ocorrencia>) {
                if (response.isSuccessful) {
                    ocorrenciaLiveData.postValue(response.body())
                } else {
                    messageLiveData.postValue("Failed to load ocorrencia.")
                }
            }

            override fun onFailure(call: Call<Ocorrencia>, t: Throwable) {
                messageLiveData.postValue("Error: ${t.message}")
            }
        })
    }

    // Add a new Ocorrencia
    fun addOcorrencia(ocorrencia: Ocorrencia) {
        repository.createOcorrencia(ocorrencia).enqueue(object : Callback<Ocorrencia> {
            override fun onResponse(call: Call<Ocorrencia>, response: Response<Ocorrencia>) {
                if (response.isSuccessful) {
                    fetchAllOcorrencias()  // Refresh the list
                    messageLiveData.postValue("Ocorrencia created successfully")
                } else {
                    messageLiveData.postValue("Error creating ocorrencia.")
                }
            }

            override fun onFailure(call: Call<Ocorrencia>, t: Throwable) {
                messageLiveData.postValue("Error: ${t.message}")
            }
        })
    }

    // Update an existing Ocorrencia
    fun updateOcorrencia(id: Int, ocorrencia: Ocorrencia) {
        repository.updateOcorrencia(id, ocorrencia).enqueue(object : Callback<Ocorrencia> {
            override fun onResponse(call: Call<Ocorrencia>, response: Response<Ocorrencia>) {
                if (response.isSuccessful) {
                    fetchAllOcorrencias()  // Refresh the list
                    messageLiveData.postValue("Ocorrencia updated successfully")
                } else {
                    messageLiveData.postValue("Error updating ocorrencia.")
                }
            }

            override fun onFailure(call: Call<Ocorrencia>, t: Throwable) {
                messageLiveData.postValue("Error: ${t.message}")
            }
        })
    }

    // Delete an Ocorrencia by ID
    fun deleteOcorrencia(id: Int) {
        repository.deleteOcorrencia(id).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    fetchAllOcorrencias()  // Refresh the list
                    messageLiveData.postValue("Ocorrencia deleted successfully")
                } else {
                    messageLiveData.postValue("Error deleting ocorrencia.")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                messageLiveData.postValue("Error: ${t.message}")
            }
        })
    }
}
