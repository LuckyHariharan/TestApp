package com.example.test.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

// domain/model/Pokemon.kt
@Entity(tableName = "pokemon")
data class Pokemon(
    @PrimaryKey val id: Int,
    val name: String,
    val imageUrl: String
)
