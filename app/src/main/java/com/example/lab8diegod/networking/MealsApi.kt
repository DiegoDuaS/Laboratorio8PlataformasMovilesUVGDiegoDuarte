package com.example.lab8diegod.networking.response

import com.example.lab8diegod.networking.response.ListMealsResponse
import retrofit2.Call
import retrofit2.http.GET

interface MealsApi {
    @GET("filter.php?c=Seafood")
    fun getMeals(): Call<ListMealsResponse>
}

