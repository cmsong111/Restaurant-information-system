package restaurant.api

import restaurant.DTO.TokenDto
import restaurant.DTO.UserInfoDto
import restaurant.DTO.UserRequestDto
import retrofit2.Call
import retrofit2.http.*

/**
 * 사용자 관련 API를 호출하는 인터페이스
 */
interface UserRepository {
    /**
     * 로그인
     * @param email 이메일
     * @param password 비밀번호
     * @return 토큰
     */
    @POST("/user/login")
    fun login(
        @Query("email") email: String,
        @Query("password") password: String
    ): Call<TokenDto>

    /**
     * 회원가입
     * @param userRequestDto 사용자 정보
     * @return 성공 여부
     */
    @POST("/user/register")
    fun register(
        @Body userRequestDto: UserRequestDto
    ): Call<UserInfoDto>

    /**
     * 사용자 정보 조회
     * @param token 토큰
     * @return 사용자 정보
     */
    @GET("/user")
    fun getUser(
        @Header("Authorization") token: String
    ): Call<UserInfoDto>

    /**
     * 회원 탈퇴
     */
    @DELETE("/user")
    fun deleteUser(
        @Header("Authorization") token: String
    ): Call<String>

    /**
     * 회원 정보 수정
     */
    @PATCH("/user")
    fun updateUser(
        @Header("Authorization") token: String,
        @Body userRequestDto: UserRequestDto
    ): Call<UserInfoDto>
}



