package org.example.data.repository.remote_repository

import org.example.data.dto.menu.MenuRequestDto
import org.example.data.dto.menu.MenuResponseDto
import org.example.data.repository.local_repository.UserRepository
import retrofit2.Call
import retrofit2.http.*

/**
 * 메뉴 정보를 관리하는 Repository
 */
interface MenuRemoteRepository {

    /**
     * 특정 가게 메뉴 목록 조회
     * @param storeId 가게 ID
     * @return 메뉴 목록
     */
    @GET("/store/{storeId}/menu")
    fun getMenuList(
        @Path("storeId") storeId: Long
    ): Call<MutableList<MenuResponseDto>>

    /**
     * 메뉴 등록
     * @param storeId 가게 ID
     * @param menuRequestDto 메뉴 정보
     * @param token 사용자 토큰
     */
    @POST("/store/{storeId}/menu")
    fun registerMenu(
        @Path("storeId") storeId: Long,
        @Body menuRequestDto: MenuRequestDto,
        @Header("Authorization") token: String = UserRepository.token!!
    ): Call<MenuResponseDto>

    /**
     * 메뉴 삭제
     * @param storeId 가게 ID
     * @param menuId 메뉴 ID
     * @param token 사용자 토큰
     * @return 삭제된 메뉴
     */
    @DELETE("/store/{storeId}/menu/{menuId}")
    fun deleteMenu(
        @Path("storeId") storeId: Long,
        @Path("menuId") menuId: Long,
        @Header("Authorization") token: String = UserRepository.token!!
    ): Call<Unit>

    /**
     * 메뉴 수정
     * @param storeId 가게 ID
     * @param menuId 메뉴 ID
     * @param menuRequestDto 메뉴 정보
     * @param token 사용자 토큰
     * @return 수정된 메뉴
     */
    @PATCH("/store/{storeId}/menu/{menuId}")
    fun modifyMenu(
        @Path("storeId") storeId: Long,
        @Path("menuId") menuId: Long,
        @Body menuRequestDto: MenuRequestDto,
        @Header("Authorization") token: String = UserRepository.token!!
    ): Call<MenuResponseDto>
}
