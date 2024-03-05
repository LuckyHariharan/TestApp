package com.example.test.domain

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.data.model.Instrument
import com.example.test.data.remote.InstrumentApiService
import com.example.test.data.repository.PokemonRepository
import com.example.test.domain.model.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InstrumentListViewModel @Inject constructor(
    private val retrofit: InstrumentApiService
) : ViewModel() {

    private val _instrumentList = MutableLiveData<List<Instrument>>()
    val instrumentList: LiveData<List<Instrument>> = _instrumentList

    init {
        loadInstrument()
    }

    private fun loadInstrument() = viewModelScope.launch {
        try {
            val response = retrofit.getInstruments() // This call is already suspend, runs on a background thread
            _instrumentList.postValue(response)
        } catch (e: Exception) {
            Log.e("ViewModel", "Error loading Pokemon", e)
        }
    }

    fun filterInstruments(type: String) = viewModelScope.launch {
        val response = retrofit.getInstruments()
        val filteredList = response.filter { it.instrument_type == type }
        _instrumentList.postValue(filteredList)
    }
}