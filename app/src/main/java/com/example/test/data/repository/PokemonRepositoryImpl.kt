package com.example.test.data.repository

import android.util.Log
import com.example.test.domain.repository.PokemonRepository
import com.example.test.data.local.PokemonDao
import com.example.test.data.remote.PokemonApiService
import com.example.test.domain.model.Pokemon
import retrofit2.Response

// data/repository/PokemonRepositoryImpl.kt
// data/repository/PokemonRepositoryImpl.kt
class PokemonRepositoryImpl(
    private val apiService: PokemonApiService,
    private val pokemonDao: PokemonDao
) : PokemonRepository {

    override suspend fun getPokemonFromAPI(): Response<List<Pokemon>> {
        Log.d("Repository", "Fetching Pokemon from API")
        return apiService.getPokemon()
    }

    override suspend fun getPokemonFromDB(): List<Pokemon> {
        Log.d("Repository", "Fetching Pokemon from DB")
        return pokemonDao.getAllPokemon()
    }

    override suspend fun savePokemon(pokemon: List<Pokemon>) {
        Log.d("Repository", "Saving Pokemon to DB")
        pokemonDao.insertAll(pokemon)
    }
}
