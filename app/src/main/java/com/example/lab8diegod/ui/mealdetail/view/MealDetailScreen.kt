import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.lifecycle.ViewModel

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableOpenTarget
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.lab8diegod.networking.response.MealDetailResponse
import com.example.lab8diegod.networking.response.MealResponse
import com.example.lab8diegod.ui.meals.view.MealsCategoriesViewModel

@Composable
fun MealDetailScreen(navController: NavController) {
    val viewModel: MealDetailViewModel = viewModel()
    val rememberedMealDetail: MutableState<List<MealDetailResponse>> = remember { mutableStateOf(emptyList<MealDetailResponse>()) }

    viewModel.getMealDetail { response ->
        val mealDetailFromTheApi = response?.meals
        rememberedMealDetail.value = mealDetailFromTheApi.orEmpty()
    }
    
    LazyColumn {
        items(rememberedMealDetail.value) { meal ->
            pantallaDetail(meal = meal)
        }
    }

}

@Composable
fun pantallaDetail(meal: MealDetailResponse){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        AsyncImage(
            model = meal.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .size(300.dp)
        )
        Text(
            text = meal.name,
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth(),
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Text(
            text = meal.category + " - " + meal.area,
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth(),
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .padding(vertical = 4.dp)
                .background(color = Color.LightGray)
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.LightGray),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "Ingredientes",
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth(),
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = meal.ingredient1 + "\n" + meal.ingredient2 + "\n" + meal.ingredient3 + "\n" + meal.ingredient4 + "\n" + meal.ingredient5 + "\n" + meal.ingredient6 + "\n" + meal.ingredient7,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth(),
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Pasos",
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth(),
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = meal.instructions,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth(),
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }
        }

    }
}