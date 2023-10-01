import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab8diegod.networking.response.MealDetailResponse
import com.example.lab8diegod.networking.response.MealResponse
import com.example.lab8diegod.ui.meals.view.MealsCategoriesViewModel

@Composable
fun MealDetailScreen() {
    val viewModel: MealDetailViewModel = viewModel()
    val rememberedMealDetail: MutableState<List<MealDetailResponse>> = remember { mutableStateOf(emptyList<MealDetailResponse>()) }

    viewModel.getMealDetail { response ->
        val mealDetailFromTheApi = response?.meals
        rememberedMealDetail.value = mealDetailFromTheApi.orEmpty()
    }
    Column(

    ){

    }
    LazyColumn {
        items(rememberedMealDetail.value) { meal ->
            Text(text = meal.name)
            Text(text = meal.imageUrl)
            Text(text = meal.id)
        }
    }

}

@Composable
fun pantallaDetail(){
    
}