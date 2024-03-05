package com.example.test.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.test.domain.model.Pokemon


@Database(entities = [Pokemon::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}
