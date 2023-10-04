/**
 * Universidad del Valle de Guatemala
 * Programación de Platafromas Móviles
 * Laboratorio 7
 * Diego Duarte 22075
 */
import androidx.lifecycle.ViewModel
import com.example.lab8diegod.networking.response.ListMealDetailResponse
import com.example.lab8diegod.networking.response.ListMealsResponse
import com.example.lab8diegod.ui.meals.repository.MealsRepository
/**
 * Clase MealsDetailViewModel
 */
class MealDetailViewModel (private val repository: MealDetailRepository = MealDetailRepository()): ViewModel() {
    fun getMealDetail(successCallback: (response: ListMealDetailResponse?) -> Unit) {
        repository.getMealDetail { response ->
            successCallback(response)
        }
    }
}