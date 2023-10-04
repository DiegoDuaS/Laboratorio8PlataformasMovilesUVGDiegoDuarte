/**
 * Universidad del Valle de Guatemala
 * Programación de Platafromas Móviles
 * Laboratorio 7
 * Diego Duarte 22075
 */
package com.example.lab8diegod.networking.response

import com.google.gson.annotations.SerializedName

/**
 * Data Class ListCategoriesResponse
 */
data class ListCategoriesResponse(val categories: List<CategoriesResponse>) {
}

/**
 * Data Class CategoriesResponse
 */
data class CategoriesResponse(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String
)