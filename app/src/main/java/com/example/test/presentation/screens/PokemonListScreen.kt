    import androidx.compose.foundation.Image
    import androidx.compose.foundation.clickable
    import androidx.compose.foundation.layout.*
    import androidx.compose.foundation.lazy.LazyColumn
    import androidx.compose.foundation.lazy.items
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.getValue
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.text.style.LineHeightStyle
    import androidx.compose.ui.unit.dp
    import androidx.navigation.NavController
    import com.example.test.domain.model.Pokemon
    import com.example.test.presentation.components.PokemonListItem
    import com.example.test.presentation.viewmodel.PokemonListViewModel
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
