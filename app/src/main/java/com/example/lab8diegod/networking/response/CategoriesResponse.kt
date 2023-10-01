package com.example.lab8diegod.networking.response

import com.google.gson.annotations.SerializedName



data class ListCategoriesResponse(val categories: List<CategoriesResponse>) {
}

data class CategoriesResponse(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String
)