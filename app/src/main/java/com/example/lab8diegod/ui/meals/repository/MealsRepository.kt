package com.example.lab8diegod.ui.meals.repository
/**
 * Universidad del Valle de Guatemala
 * Programación de Platafromas Móviles
 * Laboratorio 7
 * Diego Duarte 22075
 */

import com.example.lab8diegod.networking.MealsWebService
import com.example.lab8diegod.networking.response.ListMealsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Clase MealsRepsoitory
 */
class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    fun getMeals(successCallback: (response: ListMealsResponse?) -> Unit) {
        return webService.getMeals().enqueue(object : Callback<ListMealsResponse> {
            override fun onResponse(
                call: Call<ListMealsResponse>,
                response: Response<ListMealsResponse>
            ) {
                if (response.isSuccessful)
                    successCallback(response.body())
            }

            override fun onFailure(call: Call<ListMealsResponse>, t: Throwable) {
                // TODO treat failure
            }
        })
    }
}