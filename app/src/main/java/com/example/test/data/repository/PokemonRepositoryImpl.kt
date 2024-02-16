package com.example.test.data.repository

import com.example.test.domain.repository.PokemonRepository
import com.example.test.data.local.PokemonDao
import com.example.test.data.remote.PokemonApiService
import com.example.test.domain.model.Pokemon

// data/repository/PokemonRepositoryImpl.kt
// data/repository/PokemonRepositoryImpl.kt
class PokemonRepositoryImpl(
    private val apiService: PokemonApiService,
    private val pokemonDao: PokemonDao
) : PokemonRepository {

    override suspend fun getPokemonFromAPI(): List<Pokemon> {
        // Make a call to the API and return the result
        val response = apiService.getPokemon()
        if (response.isSuccessful) {
            // Assuming the API returns a list of Pokemon directly
            return response.body() ?: emptyList()
        } else {
            // Handle the error case or return an empty list
            return emptyList()
        }
    }

    override suspend fun getPokemonFromDB(): List<Pokemon> {
        return pokemonDao.getAllPokemon()
    }

    override suspend fun savePokemon(pokemon: List<Pokemon>) {
        pokemonDao.insertAll(pokemon)
    }
}
