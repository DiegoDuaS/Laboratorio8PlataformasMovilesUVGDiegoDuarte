/**
 * Universidad del Valle de Guatemala
 * Programación de Platafromas Móviles
 * Laboratorio 7
 * Diego Duarte 22075
 */
import com.example.lab8diegod.networking.MealDetailWebService
import com.example.lab8diegod.networking.MealsWebService
import com.example.lab8diegod.networking.response.ListMealDetailResponse
import com.example.lab8diegod.networking.response.ListMealsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Clase MealDetailsViewModel
 */
class MealDetailRepository(private val webService: MealDetailWebService = MealDetailWebService()) {
    fun getMealDetail(successCallback: (response: ListMealDetailResponse?) -> Unit) {
        return webService.getMealDetail().enqueue(object : Callback<ListMealDetailResponse> {
            override fun onResponse(
                call: Call<ListMealDetailResponse>,
                response: Response<ListMealDetailResponse>
            ) {
                if (response.isSuccessful)
                    successCallback(response.body())
            }

            override fun onFailure(call: Call<ListMealDetailResponse>, t: Throwable) {
                // TODO treat failure
            }
        })
    }
}