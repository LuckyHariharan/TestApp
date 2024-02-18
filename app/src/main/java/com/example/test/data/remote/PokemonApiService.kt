package com.example.test.data.remote

import com.example.test.domain.model.Pokemon
import com.example.test.domain.model.PokemonApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApiService {
    @GET("pokemon")
    suspend fun getPokemon(@Query("limit") limit: Int, @Query("offset") offset: Int = 0): Response<PokemonApiResponse>
}
