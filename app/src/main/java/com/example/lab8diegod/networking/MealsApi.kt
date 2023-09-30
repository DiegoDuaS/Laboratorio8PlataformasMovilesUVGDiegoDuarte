package com.example.lab8diegod.networking.response

import com.example.lab8diegod.networking.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.http.GET

interface MealsApi {
    @GET("categories.php")
    fun getMeals(): Call<MealsCategoriesResponse>
}