/**
 * Universidad del Valle de Guatemala
 * Programación de Platafromas Móviles
 * Laboratorio 7
 * Diego Duarte 22075
 */
package com.example.lab8diegod.navigation

/**
 * Class NavigationState
 */
sealed class NavigationState(val route: String) {
    object Categories: NavigationState("Cat")
    object Meals: NavigationState("Meal")
    object MealDetail: NavigationState("MealD")
}