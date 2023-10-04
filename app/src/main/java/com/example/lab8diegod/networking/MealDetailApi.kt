/**
 * Universidad del Valle de Guatemala
 * Programación de Platafromas Móviles
 * Laboratorio 7
 * Diego Duarte 22075
 */
import com.example.lab8diegod.networking.response.ListMealDetailResponse
import com.example.lab8diegod.networking.response.ListMealsResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Interface MealDetailApi
 */
interface MealDetailApi {
    @GET("lookup.php?i=52944")
    fun getMealDetail(): Call<ListMealDetailResponse>
}