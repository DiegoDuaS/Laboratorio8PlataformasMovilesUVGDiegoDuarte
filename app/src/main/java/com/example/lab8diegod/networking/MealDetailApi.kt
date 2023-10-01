import com.example.lab8diegod.networking.response.ListMealDetailResponse
import com.example.lab8diegod.networking.response.ListMealsResponse
import retrofit2.Call
import retrofit2.http.GET

interface MealDetailApi {
    @GET("filter.php?c=Seafood")
    fun getMealDetail(): Call<ListMealDetailResponse>
}