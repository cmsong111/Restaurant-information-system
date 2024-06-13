package Setting

import api.UserRepository
import org.slf4j.LoggerFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitProvider {
    private val logger = LoggerFactory.getLogger(this::class.java)

    private const val BASE_URL = "http://localhost:8080"

    private fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val userRetrofit: UserRepository = provideRetrofit().create(UserRepository::class.java)
}
