/**
 * Universidad del Valle de Guatemala
 * Programación de Platafromas Móviles
 * Laboratorio 7
 * Diego Duarte 22075
 */
package com.example.lab8diegod.ui.meals.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.lifecycle.ViewModel

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.lab8diegod.navigation.NavigationState
import com.example.lab8diegod.networking.response.CategoriesResponse
import com.example.lab8diegod.networking.response.MealResponse

/**
 * Composable MealsScreen
 */
@Composable
fun MealsScreen(navController: NavController) {
    val viewModel: MealsCategoriesViewModel = viewModel()
    val rememberedMeals: MutableState<List<MealResponse>> = remember { mutableStateOf(emptyList<MealResponse>()) }

    viewModel.getMeals { response ->
        val mealsFromTheApi = response?.meals
        rememberedMeals.value = mealsFromTheApi.orEmpty()
    }

    LazyColumn {
        items(rememberedMeals.value) { meal ->
            CardMeals(meal = meal, navController = navController)
        }
    }

}

/**
 * Composable CardsMeals
 */
@Composable
fun CardMeals(meal: MealResponse, navController: NavController){

    Card(
        modifier = Modifier
            .padding(8.dp)
            .background(color = Color.Cyan)
            .fillMaxWidth()
            .clickable {
                navController.navigate(NavigationState.MealDetail.route)
            }
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = meal.name,
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth(),
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            AsyncImage(
                model = meal.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
            )


        }
    }
}