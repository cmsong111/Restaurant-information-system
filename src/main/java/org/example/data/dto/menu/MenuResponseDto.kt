package org.example.data.dto.menu

data class MenuResponseDto(
    val id: Long,
    val name: String,
    val price: Int,
    val image: String,
    val storeId: Long
) {
    override fun toString(): String {
        return "MenuResponseDto(id=$id, name='$name', price=$price, image='$image', storeId=$storeId)"
    }
}
