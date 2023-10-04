/**
 * Universidad del Valle de Guatemala
 * Programación de Platafromas Móviles
 * Laboratorio 7
 * Diego Duarte 22075
 */
package com.example.lab8diegod.networking


import com.example.lab8diegod.networking.response.ListMealsResponse
import com.example.lab8diegod.networking.response.MealsApi
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Clase MealsWebService
 */
class MealsWebService {

    private lateinit var api: MealsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealsApi::class.java)
    }

    fun getMeals(): Call<ListMealsResponse> {
        return api.getMeals()
    }

}