package org.example.data.dto.user

data class UserRequestDto(
    val name: String,
    val email: String,
    val password: String
) {
    override fun toString(): String {
        return "UserRequestDto(name='$name', email='$email', password='$password')"
    }
}
