package com.example.test.domain

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.domain.model.Pokemon
import com.example.test.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// presentation/viewmodel/PokemonListViewModel.kt
@HiltViewModel
class PokemonListViewModel @Inject constructor(
private val repository: PokemonRepository
) : ViewModel() {

    private val _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList: LiveData<List<Pokemon>> = _pokemonList

    init {
        loadPokemon()
    }
    private fun loadPokemon() = viewModelScope.launch {
        try {
            // should be repository.getPokemon()
            val response = repository.getPokemonFromAPI()
            // Check if the response is successful should be done in data layer
            // here to quickly spin up
            // view model does not need to know where data comes from
            // shouldnt need to check if succesful or if non null
            if (response.isSuccessful && response.body() != null) {
                val pokemonApiResponse = response.body()!!
                val pokemonFromApi = pokemonApiResponse.results
                _pokemonList.postValue(pokemonFromApi)
                // Save to DB or other operations
            } else {
                Log.e("ViewModel", "API call failed: ${response.errorBody()}")
            }
        } catch (e: Exception) {
            Log.e("ViewModel", "Error loading Pokemon", e)
        }
    }
}
