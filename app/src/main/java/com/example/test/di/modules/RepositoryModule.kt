package com.example.test.di.modules

import com.example.test.data.local.PokemonDao
import com.example.test.data.remote.PokemonApiService
import com.example.test.data.repository.PokemonRepositoryImpl
import com.example.test.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// In your Dagger/Hilt module, e.g., NetworkModule.kt or a new RepositoryModule.kt
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePokemonRepository(
        apiService: PokemonApiService,
        pokemonDao: PokemonDao
    ): PokemonRepository {
        return PokemonRepositoryImpl(apiService, pokemonDao)
    }
}
