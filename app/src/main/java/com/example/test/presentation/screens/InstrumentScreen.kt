package com.example.test.presentation.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.dp
import com.example.test.domain.InstrumentListViewModel
import com.example.test.domain.PokemonListViewModel
import com.example.test.presentation.components.PokemonListItem

@Composable
fun InstrumentScreen(viewModel: InstrumentListViewModel) {
    val instrumentList by viewModel.instrumentList.observeAsState(initial = emptyList())

    LazyColumn {
        item() {
            Row(
                modifier = Modifier.padding(16.dp)
            ) {
                Button(
                    modifier = Modifier.padding(16.dp),
                    content = { Text("stock") },
                    onClick = { viewModel.filterInstruments("stock") })
                Button(
                    modifier = Modifier.padding(16.dp),
                    content = { Text("etf") },
                    onClick = { viewModel.filterInstruments("etf") })
                Button(
                    modifier = Modifier.padding(16.dp),
                    content = { Text("crypto") },
                    onClick = { viewModel.filterInstruments("crypto") })
            }
        }
        items(instrumentList) { instruments ->
            Row(modifier = Modifier.padding(16.dp)) {
                Text(text = instruments.name)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = instruments.instrument_type)
            }
        }
    }
}
