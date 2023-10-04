package com.example.lab8diegod.navigation

sealed class NavigationState(val route: String) {
    object Categories: NavigationState("Cat")
    object Meals: NavigationState("Meal")
    object MealDetail: NavigationState("MealD")
}