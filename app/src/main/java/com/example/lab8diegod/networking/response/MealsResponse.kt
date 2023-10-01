package com.example.lab8diegod.networking.response

import com.google.gson.annotations.SerializedName


data class ListMealsResponse(val meals: List<MealResponse>)

data class MealResponse(
    @SerializedName("strMeal") val name: String,
    @SerializedName("strMealThumb") val imageUrl: String,
    @SerializedName("idMeal") val id: String
)