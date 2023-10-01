package com.example.lab8diegod.networking


import MealDetailApi
import com.example.lab8diegod.networking.response.ListMealDetailResponse
import com.example.lab8diegod.networking.response.ListMealsResponse
import com.example.lab8diegod.networking.response.MealsApi
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory

class MealDetailWebService {

    private lateinit var api: MealDetailApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealDetailApi::class.java)
    }

    fun getMealDetail(): Call<ListMealDetailResponse> {
        return api.getMealDetail()
    }

}