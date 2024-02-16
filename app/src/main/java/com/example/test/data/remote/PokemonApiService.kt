package com.example.test.data.remote

import com.example.test.domain.model.Pokemon
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApiService {
    @GET("pokemon")
    suspend fun getPokemon(): Response<List<Pokemon>>
}
