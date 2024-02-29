import android.util.Log
import com.example.test.data.local.PokemonDao
import com.example.test.data.remote.PokemonApiService
import com.example.test.domain.model.Pokemon
import com.example.test.data.repository.PokemonRepository

class PokemonRepositoryImpl(
    private val apiService: PokemonApiService,
    private val pokemonDao: PokemonDao
) : PokemonRepository {

    override suspend fun getPokemon(): List<Pokemon> {
        Log.d("Repository", "Fetching Pokemon from API")
        val response = apiService.getPokemon(limit = 1000)
        if (response.isSuccessful) {
            Log.d("Repository", "Fetched ${response.body()?.results?.size ?: 0} Pokemon from API")
            savePokemon(response.body()?.results ?: emptyList())
        } else {
            Log.e("Repository", "Failed to fetch Pokemon: ${response.code()}")
        }
        val dbPokemon = getPokemonFromDB()
        Log.d("Repository", "Fetched ${dbPokemon.size} Pokemon from DB")
        return dbPokemon
    }

    private suspend fun getPokemonFromDB(): List<Pokemon> {
        return pokemonDao.getAllPokemon().also { pokemonList ->
            Log.d("Repository", "Pokemon in DB: ${pokemonList.size}")
        }
    }

    private suspend fun savePokemon(pokemonList: List<Pokemon>) {
        val pokemonDomainList = pokemonList.map { apiPokemon ->
            // Use the defined function to extract ID from the URL
            val pokemonId = getPokemonIdFromUrl(apiPokemon.url).toIntOrNull() ?: 0
            Pokemon(
                id = pokemonId, // Use the parsed ID
                name = apiPokemon.name,
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$pokemonId.png",
                url = apiPokemon.url
            )
        }
        pokemonDao.insertAll(pokemonDomainList)
        Log.d("Repository", "Saved ${pokemonDomainList.size} Pokemon to DB")
    }

    private fun getPokemonIdFromUrl(url: String): String {
        return url.trimEnd('/').substringAfterLast('/')
    }
}
