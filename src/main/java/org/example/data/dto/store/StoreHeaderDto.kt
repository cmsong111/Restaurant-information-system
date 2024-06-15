package org.example.data.dto.store


data class StoreHeaderDto(
    val id: Long,
    val name: String,
    val image: String,
    val location: String,
    val category: FoodType,
    val businessHour: String,
    var description: String,
) {
    override fun toString(): String {
        return "StoreHeaderDto(id=$id, name='$name', image='$image', location='$location', category=$category, businessHour='$businessHour', description='$description')"
    }
}
