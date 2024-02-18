package com.example.test.data.repository

import android.util.Log
import com.example.test.domain.repository.PokemonRepository
import com.example.test.data.local.PokemonDao
import com.example.test.data.remote.PokemonApiService
import com.example.test.domain.model.Pokemon
import com.example.test.domain.model.PokemonApiResponse
import retrofit2.Response

class PokemonRepositoryImpl(
    private val apiService: PokemonApiService,
    private val pokemonDao: PokemonDao
) : PokemonRepository {

    override suspend fun getPokemonFromAPI(): Response<PokemonApiResponse> {
        Log.d("Repository", "Fetching Pokemon from API")
        val response = apiService.getPokemon(limit = 1000)
        if (response.isSuccessful) {
            Log.d("Repository", "Pokemon fetched successfully: ${response.body()}")
        } else {
            Log.e("Repository", "Failed to fetch Pokemon: ${response.code()}")
        }
        return response
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
