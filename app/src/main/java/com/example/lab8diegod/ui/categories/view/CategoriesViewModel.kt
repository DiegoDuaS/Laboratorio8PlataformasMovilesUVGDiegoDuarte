/**
 * Universidad del Valle de Guatemala
 * Programación de Platafromas Móviles
 * Laboratorio 7
 * Diego Duarte 22075
 */
package com.example.lab8diegod.ui.categories.view

import androidx.lifecycle.ViewModel
import com.example.lab8diegod.networking.response.CategoriesResponse
import com.example.lab8diegod.networking.response.ListCategoriesResponse
import com.example.lab8diegod.ui.categories.repository.CategoriesRepository
import com.example.lab8diegod.ui.meals.repository.MealsRepository
/**
 * Clase CategoriesViewModel
 */
class CategoriesViewModel (private val repository: CategoriesRepository = CategoriesRepository()): ViewModel() {
    fun getCategories(successCallback: (response: ListCategoriesResponse?) -> Unit) {
        repository.getCategories { response ->
            successCallback(response)
        }
    }
}