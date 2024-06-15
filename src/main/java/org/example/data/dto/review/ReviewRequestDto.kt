package org.example.data.dto.review

/**
 * 리뷰 생성 요청 DTO
 */
data class ReviewRequestDto(
    val title: String,
    val content: String,
    val image: String?,
    val score: Int,
) {
    override fun toString(): String {
        return "ReviewRequestDto(title='$title', content='$content', image=$image, score=$score)"
    }
}
