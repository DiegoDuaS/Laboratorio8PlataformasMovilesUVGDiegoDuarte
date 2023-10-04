/**
 * Universidad del Valle de Guatemala
 * Programación de Platafromas Móviles
 * Laboratorio 7
 * Diego Duarte 22075
 */
import com.example.lab8diegod.networking.CategoriesApi
import com.example.lab8diegod.networking.response.CategoriesResponse
import com.example.lab8diegod.networking.response.ListCategoriesResponse
import com.example.lab8diegod.networking.response.MealsApi
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
/**
 * Clase CategoriesWebService
 */
class CategoriesWebService {

    private lateinit var api: CategoriesApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(CategoriesApi::class.java)
    }

    fun getCategroies(): Call<ListCategoriesResponse> {
        return api.getCategories()
    }
}