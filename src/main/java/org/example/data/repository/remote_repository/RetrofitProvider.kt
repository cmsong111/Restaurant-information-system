package org.example.data.repository.remote_repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Retrofit 객체를 제공하는 싱글톤 객체
 * Retrofit 객체를 생성하고 필요한 Repository를 생성하여 제공한다.
 */
object RetrofitProvider {
    /** Server Base URL
     * 서버 주소가 변경되면 이곳만 변경하면 된다.
     */
    private const val BASE_URL = "http://localhost:8080"
    
    private val mainServer = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private val locationServer = Retrofit.Builder()
        .baseUrl("https://ifconfig.co/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    /** User 관련 API 호출 Repository */
    val userRetrofit: UserRemoteRepository = mainServer.create(UserRemoteRepository::class.java)

    /** Store 관련 API 호출 Repository */
    val storeRetrofit: StoreRemoteRepository = mainServer.create(StoreRemoteRepository::class.java)

    /** Review 관련 API 호출 Repository */
    val reviewRetrofit: ReviewRemoteRepository = mainServer.create(ReviewRemoteRepository::class.java)

    /** Menu 관련 API 호출 Repository */
    val menuRetrofit: MenuRemoteRepository = mainServer.create(MenuRemoteRepository::class.java)

    /** Location 관련 API 호출 Repository */
    val locationRepository: LocationRemoteRepository = locationServer.create(LocationRemoteRepository::class.java)
}
