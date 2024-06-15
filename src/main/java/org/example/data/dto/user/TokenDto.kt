package org.example.data.dto.user

/**
 * 토큰 DTO

 */
data class TokenDto(
    /**
     * Bearer Token 값
     */
    val token: String
) {
    override fun toString(): String {
        return "TokenDto(token='$token')"
    }
}
