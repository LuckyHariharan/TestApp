package com.example.test.domain.repository

import com.example.test.domain.model.Pokemon
import com.example.test.domain.model.PokemonApiResponse
import retrofit2.Response

// domain/repository/PokemonRepository.kt
interface PokemonRepository {
    suspend fun getPokemonFromAPI(): Response<PokemonApiResponse>
    suspend fun getPokemonFromDB(): List<Pokemon>
    suspend fun savePokemon(pokemon: List<Pokemon>)
}
