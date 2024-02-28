package com.example.test.data.repository

import android.util.Log
import com.example.test.data.local.PokemonDao
import com.example.test.data.model.PokemonApiResponse
import com.example.test.data.remote.PokemonApiService
import com.example.test.domain.model.Pokemon
import retrofit2.Response

class PokemonRepositoryImpl(
    private val apiService: PokemonApiService,
    private val pokemonDao: PokemonDao
) : PokemonRepository {
// doing the dirty work of data logic
    override suspend fun getPokemon(): List<Pokemon> {
        Log.d("Repository", "Fetching Pokemon from API")
        val response = apiService.getPokemon(limit = 1000)
        if (response.isSuccessful) {
            savePokemon(response.body()?.results ?: emptyList())
            Log.d("Repository", "Pokemon fetched successfully: ${response.body()}")
        } else {
            Log.e("Repository", "Failed to fetch Pokemon: ${response.code()}")
        }
        return getPokemonFromDB()
    }


    // everything should run through dao


    suspend fun getPokemonFromDB(): List<Pokemon> {
        Log.d("Repository", "Fetching Pokemon from DB")
        return pokemonDao.getAllPokemon()
    }

    suspend fun savePokemon(pokemon: List<Pokemon>) {
        Log.d("Repository", "Saving Pokemon to DB")
        pokemonDao.insertAll(pokemon)
    }
}
