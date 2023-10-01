import androidx.lifecycle.ViewModel
import com.example.lab8diegod.networking.response.ListMealDetailResponse
import com.example.lab8diegod.networking.response.ListMealsResponse
import com.example.lab8diegod.ui.meals.repository.MealsRepository

class MealDetailViewModel (private val repository: MealDetailRepository = MealDetailRepository()): ViewModel() {
    fun getMealDetail(successCallback: (response: ListMealDetailResponse?) -> Unit) {
        repository.getMealDetail { response ->
            successCallback(response)
        }
    }
}