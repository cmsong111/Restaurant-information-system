package org.example.data.dto.menu


data class MenuRequestDto(
    val name: String,
    val price: Int,
    val image: String
) {
    override fun toString(): String {
        return "MenuRequestDto(name='$name', price=$price, image='$image')"
    }
}
