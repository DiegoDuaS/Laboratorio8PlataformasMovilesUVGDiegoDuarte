package com.example.lab8diegod.ui.categories.repository

import CategoriesWebService
import com.example.lab8diegod.networking.response.CategoriesResponse
import com.example.lab8diegod.networking.response.ListCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoriesRepository(private val webService: CategoriesWebService = CategoriesWebService()) {
    fun getCategories(successCallback: (response: ListCategoriesResponse?) -> Unit) {
        return webService.getCategroies().enqueue(object : Callback<ListCategoriesResponse> {
            override fun onResponse(
                call: Call<ListCategoriesResponse>,
                response: Response<ListCategoriesResponse>
            ) {
                if (response.isSuccessful)
                    successCallback(response.body())
            }

            override fun onFailure(call: Call<ListCategoriesResponse>, t: Throwable) {
                // TODO treat failure
            }
        })
    }
}