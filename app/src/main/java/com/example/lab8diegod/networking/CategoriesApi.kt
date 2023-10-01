package com.example.lab8diegod.networking

import com.example.lab8diegod.networking.response.CategoriesResponse
import com.example.lab8diegod.networking.response.ListCategoriesResponse
import retrofit2.Call
import retrofit2.http.GET

interface CategoriesApi {
    @GET("categories.php")
    fun getCategories(): Call<ListCategoriesResponse>
}