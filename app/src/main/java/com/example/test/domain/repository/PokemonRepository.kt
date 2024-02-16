package com.example.test.domain.repository

import com.example.test.domain.model.Pokemon

// domain/repository/PokemonRepository.kt
interface PokemonRepository {
    suspend fun getPokemonFromAPI(): List<Pokemon>
    suspend fun getPokemonFromDB(): List<Pokemon>
    suspend fun savePokemon(pokemon: List<Pokemon>)
}
