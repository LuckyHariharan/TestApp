package com.example.test.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.domain.model.Pokemon
import com.example.test.domain.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// presentation/viewmodel/PokemonListViewModel.kt
@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {
    annotation class ViewModelInject

    private val _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList: LiveData<List<Pokemon>> = _pokemonList

    init {
        loadPokemon()
    }
    private fun loadPokemon() {
        viewModelScope.launch {
            try {
                Log.d("ViewModel", "Loading Pokemon data")

                val pokemonFromDb = repository.getPokemonFromDB()
                if (pokemonFromDb.isNotEmpty()) {
                    _pokemonList.postValue(pokemonFromDb)
                } else {
                    val pokemonFromApi = repository.getPokemonFromAPI()
                    _pokemonList.postValue(pokemonFromApi)
                    repository.savePokemon(pokemonFromApi)
                }
            } catch (e: Exception) {
                Log.e("ViewModel", "Error loading Pokemon", e)

            }
        }
    }
}
