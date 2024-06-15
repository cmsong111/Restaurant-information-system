package org.example.data.repository.remote_repository

import org.example.data.dto.review.ReviewRequestDto
import org.example.data.dto.review.ReviewResponseDto
import org.example.data.repository.local_repository.UserRepository
import retrofit2.Call
import retrofit2.http.*

interface ReviewRemoteRepository {

    /**
     * 리뷰 생성
     * @param storeId 상점 ID
     * @param reviewRequestDto 리뷰 정보
     * @param token 사용자 토큰
     * @return 생성된 리뷰
     */
    @POST("/review/{storeId}")
    fun createReview(
        @Path("storeId") storeId: Long,
        @Body reviewRequestDto: ReviewRequestDto,
        @Header("Authorization") token: String = UserRepository.token!!
    ): Call<ReviewResponseDto>

    /**
     * 리뷰 수정
     * @param reviewId 리뷰 ID
     * @param reviewRequestDto 리뷰 정보
     * @param token 사용자 토큰(관리자, 리뷰 작성자만 가능)
     */
    @PATCH("/review/{reviewId}")
    fun modifyReview(
        @Path("reviewId") reviewId: Long,
        @Body reviewRequestDto: ReviewRequestDto,
        @Header("Authorization") token: String = UserRepository.token!!
    ): Call<ReviewResponseDto>

    /**
     *  리뷰 삭제
     *  @param reviewId 리뷰 ID
     *  @param token 사용자 토큰(관리자, 리뷰 작성자만 가능)
     */
    @DELETE("/review/{reviewId}")
    fun deleteReview(
        @Path("reviewId") reviewId: Long,
        @Header("Authorization") token: String = UserRepository.token!!
    ): Call<Unit>

    /**
     * 내가 작성한 리뷰 목록 조회
     * @param token 사용자 토큰
     * @return 리뷰 목록
     */
    @GET("/review")
    fun getMyReviewList(
        @Header("Authorization") token: String = UserRepository.token!!
    ): Call<MutableList<ReviewResponseDto>>
}
