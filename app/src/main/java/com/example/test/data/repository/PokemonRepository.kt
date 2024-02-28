package com.example.test.data.repository

import com.example.test.data.model.PokemonApiResponse
import com.example.test.domain.model.Pokemon
import retrofit2.Response

// domain/repository/PokemonRepository.kt

// any object tht implement this interface will be able to fetch data from the API and the database
// and needs to supply these method implementations
interface PokemonRepository {

    // dont expose where we get api from view model
// passing to view model
    // if you want to use this temlate
    // supply a getpokmeon method that returns a list of pokemon
    suspend fun getPokemon(): List<Pokemon>
}
