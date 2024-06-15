package org.example.data.repository.remote_repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitProvider {
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


    val userRetrofit: UserRemoteRepository = mainServer().create(UserRemoteRepository::class.java)

    val storeRetrofit: StoreRemoteRepository = mainServer().create(StoreRemoteRepository::class.java)

    val reviewRetrofit: ReviewRemoteRepository = mainServer().create(ReviewRemoteRepository::class.java)

    val menuRetrofit: MenuRemoteRepository = mainServer().create(MenuRemoteRepository::class.java)

    val locationRepository: LocationRemoteRepository = locationServer().create(LocationRemoteRepository::class.java)
}
