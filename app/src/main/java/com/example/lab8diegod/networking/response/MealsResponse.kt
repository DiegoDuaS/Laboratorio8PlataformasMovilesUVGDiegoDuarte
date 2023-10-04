/**
 * Universidad del Valle de Guatemala
 * Programación de Platafromas Móviles
 * Laboratorio 7
 * Diego Duarte 22075
 */
package com.example.lab8diegod.networking.response

import com.google.gson.annotations.SerializedName


/**
 * Data Class ListMealsResponse
 */
data class ListMealsResponse(val meals: List<MealResponse>)


/**
 * Data Class MealsResponse
 */
data class MealResponse(
    @SerializedName("strMeal") val name: String,
    @SerializedName("strMealThumb") val imageUrl: String,
    @SerializedName("idMeal") val id: String
)