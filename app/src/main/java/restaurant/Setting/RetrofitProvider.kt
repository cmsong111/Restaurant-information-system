package restaurant.Setting

import restaurant.api.LocationRepository
import restaurant.api.StoreRepository
import restaurant.api.UserRepository
import org.slf4j.LoggerFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitProvider {
    private val logger = LoggerFactory.getLogger(this::class.java)

    private const val BASE_URL = "http://localhost:8080"

    private fun mainServer(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun locationServer(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://ifconfig.co/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val userRetrofit: UserRepository = mainServer().create(UserRepository::class.java)

    val storeRetrofit: StoreRepository = mainServer().create(StoreRepository::class.java)

    val locationRepository: LocationRepository = locationServer().create(LocationRepository::class.java)
}
