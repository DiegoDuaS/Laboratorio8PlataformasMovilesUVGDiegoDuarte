/**
 * Universidad del Valle de Guatemala
 * Programación de Platafromas Móviles
 * Laboratorio 7
 * Diego Duarte 22075
 */
package com.example.lab8diegod.networking.response

import com.example.lab8diegod.networking.response.ListMealsResponse
import retrofit2.Call
import retrofit2.http.GET
/**
 * Interface MealsApi
 */
interface MealsApi {
    @GET("filter.php?c=Seafood")
    fun getMeals(): Call<ListMealsResponse>
}

