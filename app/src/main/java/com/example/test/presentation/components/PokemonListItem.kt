    package com.example.test.presentation.components

    import android.util.Log
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
    fun getPokemonIdFromUrl(url: String): String {
        // Assuming the URL ends with "{id}/", split by "/"
        val parts = url.split("/")
        // The ID should be the second to last part of the URL
        return parts[parts.size - 2]
    }


    @Composable
    fun PokemonListItem(pokemon: Pokemon) {
        Log.d("Composable", "PokemonListScreen called")

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {            val pokemonId = getPokemonIdFromUrl(pokemon.url)
            val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$pokemonId.png"

            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(data = imageUrl)
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
