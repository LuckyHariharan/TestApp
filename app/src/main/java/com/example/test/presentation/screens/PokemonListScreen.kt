//import androidx.compose.foundation.Image
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import com.example.test.domain.model.Pokemon
//
//@Composable
//fun PokemonListItem(pokemon: Pokemon, navController: NavController) {
//    Row(modifier = Modifier
//        .fillMaxWidth()
//        .clickable {
//            navController.navigate("pokemonDetail/${pokemon.id}")
//        }) {
//        Image(
//            painter = rememberImagePainter(
//                data = pokemon.imageUrl,
//                builder = {
//                    crossfade(true)
//                    placeholder(R.drawable.placeholder)
//                }
//            ),
//            contentDescription = "Pokemon Image",
//            modifier = Modifier.size(60.dp)
//        )
//
//        Column(modifier = Modifier.padding(8.dp)) {
//            Text(text = pokemon.name, fontWeight = FontWeight.Bold)
//            // You can add more details here
//            Text(text = "ID: ${pokemon.id}")
//        }
//    }
//}
