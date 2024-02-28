package com.example.test.domain.model

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey

// domain or data layer
@Entity(tableName = "pokemon")
data class Pokemon(
    @PrimaryKey val id: Int,
    val name: String,
    @Nullable val imageUrl: String?, // or just 'url' if that's what you receive from the API
    val url: String
)

// Response model to match the API structure
