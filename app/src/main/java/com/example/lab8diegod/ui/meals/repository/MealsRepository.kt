package com.example.lab8diegod.ui.meals.repository

import com.example.lab8diegod.networking.MealsWebService
import com.example.lab8diegod.networking.response.ListMealsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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