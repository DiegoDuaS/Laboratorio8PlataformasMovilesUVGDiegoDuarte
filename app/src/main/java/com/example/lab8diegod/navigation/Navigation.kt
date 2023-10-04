package com.example.lab8diegod.navigation

import MealDetailScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab8diegod.ui.categories.view.CategoriesScreen
import com.example.lab8diegod.ui.meals.view.MealsScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = NavigationState.Categories.route,
        modifier = modifier) {
        composable(route = NavigationState.Categories.route) {
            CategoriesScreen(navController = navController)
        }
        composable(route = NavigationState.Meals.route) {
            MealsScreen(navController = navController)
        }
        composable(route = NavigationState.MealDetail.route) {
            MealDetailScreen(navController = navController)
        }
    }
}