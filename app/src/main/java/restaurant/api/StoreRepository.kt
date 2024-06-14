package restaurant.api

import restaurant.DTO.FoodType
import restaurant.DTO.StoreHeaderDto
import restaurant.DTO.StoreRequestDto
import retrofit2.Call
import retrofit2.http.*


/**
 * 상점 정보를 관리하는 Repository
 */
interface StoreRepository {

    /**
     * 상점 목록 조회
     * @param latitude 위도
     * @param longitude 경도
     * @param name 상점 이름
     * @param category 음식 종류
     * @return 상점 목록
     */
    @GET
    fun getStoreList(
        @Query("latitude") latitude: Double?,
        @Query("longitude") longitude: Double?,
        @Query("name") name: String?,
        @Query("category") category: FoodType?,
    ): Call<List<StoreHeaderDto>>

    /**
     * 상점 등록
     */
    @POST
    fun registerStore(
        @Header("Authorization") token: String,
        @Body storeRequestDto: StoreRequestDto
    ): Call<StoreHeaderDto>
}
