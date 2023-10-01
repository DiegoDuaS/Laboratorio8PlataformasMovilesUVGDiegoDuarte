package com.example.lab8diegod.ui.meals.view
import androidx.lifecycle.ViewModel
import com.example.lab8diegod.networking.response.ListMealsResponse
import com.example.lab8diegod.ui.meals.repository.MealsRepository

class MealsCategoriesViewModel (private val repository: MealsRepository = MealsRepository()): ViewModel() {
    fun getMeals(successCallback: (response: ListMealsResponse?) -> Unit) {
        repository.getMeals { response ->
            successCallback(response)
        }
    }
}