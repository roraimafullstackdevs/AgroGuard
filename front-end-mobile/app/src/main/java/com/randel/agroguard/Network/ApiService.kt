package com.randel.agroguard.Network

import com.randel.agroguard.Data.Model.Produtor
import com.randel.agroguard.Data.Model.Ocorrencia
import com.randel.agroguard.Data.Model.Tecnico
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    // --- PRODUTOR CRUD ---

    // Get all Produtor records
    @GET("produtores")
    fun getAllProdutores(): Call<List<Produtor>>

    // Get a single Produtor by ID
    @GET("produtores/{id}")
    fun getProdutorById(@Path("id") id: Int): Call<Produtor>

    // Create a new Produtor
    @POST("produtores")
    fun createProdutor(@Body produtor: Produtor): Call<Produtor>

    // Update an existing Produtor
    @PUT("produtores/{id}")
    fun updateProdutor(@Path("id") id: Int, @Body produtor: Produtor): Call<Produtor>

    // Delete a Produtor by ID
    @DELETE("produtores/{id}")
    fun deleteProdutor(@Path("id") id: Int): Call<Void>


    // --- OCORRENCIA CRUD ---

    // Get all Ocorrencia records
    @GET("ocorrencias")
    fun getAllOcorrencias(): Call<List<Ocorrencia>>

    // Get a single Ocorrencia by ID
    @GET("ocorrencias/{id}")
    fun getOcorrenciaById(@Path("id") id: Int): Call<Ocorrencia>

    // Create a new Ocorrencia
    @POST("ocorrencias")
    fun createOcorrencia(@Body ocorrencia: Ocorrencia): Call<Ocorrencia>

    // Update an existing Ocorrencia
    @PUT("ocorrencias/{id}")
    fun updateOcorrencia(@Path("id") id: Int, @Body ocorrencia: Ocorrencia): Call<Ocorrencia>

    // Delete an Ocorrencia by ID
    @DELETE("ocorrencias/{id}")
    fun deleteOcorrencia(@Path("id") id: Int): Call<Void>


    // --- TECNICO CRUD ---

    // Get all Tecnico records
    @GET("tecnicos")
    fun getAllTecnicos(): Call<List<Tecnico>>

    // Get a single Tecnico by ID
    @GET("tecnicos/{id}")
    fun getTecnicoById(@Path("id") id: Int): Call<Tecnico>

    // Create a new Tecnico
    @POST("tecnicos")
    fun createTecnico(@Body tecnico: Tecnico): Call<Tecnico>

    // Update an existing Tecnico
    @PUT("tecnicos/{id}")
    fun updateTecnico(@Path("id") id: Int, @Body tecnico: Tecnico): Call<Tecnico>

    // Delete a Tecnico by ID
    @DELETE("tecnicos/{id}")
    fun deleteTecnico(@Path("id") id: Int): Call<Void>
}
