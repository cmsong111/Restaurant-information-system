package org.example.data.dto.review

/**
 * 리뷰 조회 응답 DTO
 */
data class ReviewResponseDto(
    val id: Long,
    val title: String,
    val content: String,
    val image: String?,
    val score: Int,
    val storeId: Long,
    val userName: String,
) {
    override fun toString(): String {
        return "ReviewResponseDto(id=$id, title='$title', content='$content', image=$image, score=$score, storeId=$storeId, userName='$userName')"
    }
}
