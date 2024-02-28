import androidx.compose.foundation.lazy.LazyColumn
    import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
    import androidx.compose.runtime.getValue
import com.example.test.presentation.components.PokemonListItem
    import com.example.test.domain.PokemonListViewModel
    import androidx.compose.runtime.livedata.observeAsState

    @Composable
    fun PokemonListScreen(viewModel: PokemonListViewModel) {
        val pokemonList by viewModel.pokemonList.observeAsState(initial = emptyList())

        LazyColumn {
            items(pokemonList) { pokemon ->
                PokemonListItem(pokemon)
            }
        }
    }
