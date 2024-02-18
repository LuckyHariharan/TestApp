package com.example.test.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.test.domain.model.Pokemon

@Composable
fun PokemonListItem(pokemon: Pokemon) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(data = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${pokemon.id}.png")
                    .apply(block = fun ImageRequest.Builder.() {
                        crossfade(true)
                    }).build()
            ),
            contentDescription = "${pokemon.name} image",
            modifier = Modifier.size(60.dp)
        )

        Spacer(Modifier.width(16.dp))

        Column {
            Text(text = pokemon.name, fontWeight = FontWeight.Bold)
            Text(text = pokemon.url)
        }
    }
}
