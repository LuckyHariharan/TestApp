package com.example.test.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

// domain/model/Pokemon.kt
@Entity(tableName = "pokemon")
data class Pokemon(
    @PrimaryKey val id: Int,
    val name: String,
    val imageUrl: String, // or just 'url' if that's what you receive from the API
    val url: String
)

// Response model to match the API structure
data class PokemonApiResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Pokemon>
)
