package com.example.lab8diegod.ui.meals.view
import androidx.lifecycle.ViewModel
import com.example.lab8diegod.networking.response.MealsCategoriesResponse
import com.example.lab8diegod.ui.meals.repository.MealsRepository

class MealsCategoriesViewModel (private val repository: MealsRepository = MealsRepository()): ViewModel() {
    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        repository.getMeals { response ->
            successCallback(response)
        }
    }
}