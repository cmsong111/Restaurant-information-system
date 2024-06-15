package org.example.data.repository.remote_repository

import org.example.data.dto.store.FoodType
import org.example.data.dto.store.StoreHeaderDto
import org.example.data.dto.store.StoreRequestDto
import org.example.data.dto.store.StoreResponseDto
import org.example.data.repository.local_repository.UserLocalRepository
import retrofit2.Call
import retrofit2.http.*


/**
 * 상점 정보를 관리하는 Repository
 */
interface StoreRemoteRepository {

    /**
     * 상점 목록 조회
     *
     * 위도 경도에 null을 넣으면 모든 가게 조회
     * @param latitude 위도
     * @param longitude 경도
     * @param name 상점 이름
     * @param category 음식 종류
     * @return 상점 목록
     */
    @GET("/store")
    fun getStoreList(
        @Query("latitude") latitude: Double? = UserLocalRepository.location!!.latitude,
        @Query("longitude") longitude: Double? = UserLocalRepository.location!!.longitude,
        @Query("name") name: String? = null,
        @Query("category") category: FoodType? = null,
    ): Call<MutableList<StoreHeaderDto>>

    /**
     * 상점 등록
     * @param token 사용자 토큰
     * @param storeRequestDto 상점 정보
     */
    @POST("/store")
    fun registerStore(
        @Header("Authorization") token: String = UserLocalRepository.token!!,
        @Body storeRequestDto: StoreRequestDto
    ): Call<StoreHeaderDto>

    /**
     * 상점 상세 조회
     * @param id 상점 ID
     */
    @GET("/store/{id}")
    fun getStoreDetail(
        @Path("id") id: Long
    ): Call<StoreResponseDto>

    /**
     * 상점 삭제 요청 (관리자만 가능)
     * @param token 사용자 토큰
     * @param id 상점 ID
     */
    @DELETE("/store/{id}")
    fun deleteStore(
        @Path("id") id: Long,
        @Header("Authorization") token: String = UserLocalRepository.token!!
    ): Call<String>

    /**
     * 랜덤 가게 조회
     * 위도 경도에 null을 넣으면 모든 가게 중 랜덤으로 조회
     * @param latitude 위도
     * @param longitude 경도
     */
    @GET("/store/random")
    fun getRandomStore(
        @Query("latitude") latitude: Double? = UserLocalRepository.location!!.latitude,
        @Query("longitude") longitude: Double? = UserLocalRepository.location!!.longitude
    ): Call<StoreResponseDto>

    /**
     * 내 가게 조회(관리자만 가능)
     * @param token 사용자 토큰 (관리자)
     */
    @GET("/store/myStore")
    fun getMyStore(
        @Header("Authorization") token: String = UserLocalRepository.token!!
    ): Call<List<StoreHeaderDto>>
}
