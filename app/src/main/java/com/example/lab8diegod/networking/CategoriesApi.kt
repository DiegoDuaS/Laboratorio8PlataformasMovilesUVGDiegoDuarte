/**
 * Universidad del Valle de Guatemala
 * Programación de Platafromas Móviles
 * Laboratorio 7
 * Diego Duarte 22075
 */
package com.example.lab8diegod.networking

import com.example.lab8diegod.networking.response.CategoriesResponse
import com.example.lab8diegod.networking.response.ListCategoriesResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Interface CategoriesApi
 */
interface CategoriesApi {
    @GET("categories.php")
    fun getCategories(): Call<ListCategoriesResponse>
}