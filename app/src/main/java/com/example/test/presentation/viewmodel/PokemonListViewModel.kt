package com.example.test.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.domain.model.Pokemon
import com.example.test.domain.repository.PokemonRepository
import kotlinx.coroutines.launch

// presentation/viewmodel/PokemonListViewModel.kt
class PokemonListViewModel(private val repository: PokemonRepository) : ViewModel() {
    private val _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList: LiveData<List<Pokemon>> = _pokemonList

    init {
        loadPokemon()
    }

    private fun loadPokemon() {
        viewModelScope.launch {
            val pokemonFromDb = repository.getPokemonFromDB()
            if (pokemonFromDb.isNotEmpty()) {
                _pokemonList.postValue(pokemonFromDb)
            } else {
                val pokemonFromApi = repository.getPokemonFromAPI()
                _pokemonList.postValue(pokemonFromApi)
                repository.savePokemon(pokemonFromApi)
            }
        }
    }
}
