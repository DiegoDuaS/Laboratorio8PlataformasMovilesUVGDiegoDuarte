package com.example.lab8diegod.ui.categories.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.example.lab8diegod.navigation.NavigationState
import com.example.lab8diegod.networking.response.CategoriesResponse
import com.example.lab8diegod.networking.response.MealResponse
import com.example.lab8diegod.ui.meals.view.MealsCategoriesViewModel

@Composable
fun CategoriesScreen(navController: NavController) {
    val viewModel: CategoriesViewModel = viewModel()
    val rememberedCategories: MutableState<List<CategoriesResponse>> = remember { mutableStateOf(emptyList<CategoriesResponse>()) }

    viewModel.getCategories { response ->
        val categoriesFromTheApi = response?.categories
        rememberedCategories.value = categoriesFromTheApi.orEmpty()
    }

    LazyColumn {
        items(rememberedCategories.value) { category ->
            CardCategory(categoria = category, navController)
        }
    }

}

@Composable
fun CardCategory(categoria: CategoriesResponse, navController: NavController){

    Card(
        modifier = Modifier
            .padding(8.dp)
            .background(color = Color.Cyan)
            .fillMaxWidth()
            .clickable {
                navController.navigate(NavigationState.Meals.route)
            }
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = categoria.name,
                style = androidx.compose.material.MaterialTheme.typography.h4,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth(),
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            AsyncImage(
                model = categoria.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
            )
            Text(
                text = categoria.description,
                style = androidx.compose.material.MaterialTheme.typography.subtitle1,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth(),
                color = Color.Black,
                textAlign = TextAlign.Center
            )

        }
    }
}