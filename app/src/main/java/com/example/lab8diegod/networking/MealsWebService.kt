package com.example.lab8diegod.networking.response


import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import com.example.lab8diegod.networking.response.MealsCategoriesResponse

class MealsWebService {

    private lateinit var api: MealsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealsApi::class.java)
    }

    fun getMeals(): Call<MealsCategoriesResponse> {
        return api.getMeals()
    }
}