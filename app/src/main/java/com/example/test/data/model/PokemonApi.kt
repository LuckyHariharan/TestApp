package com.example.test.data.model

import com.example.test.domain.model.Pokemon


// map from data to domain layer

data class PokemonApiResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Pokemon>
)
