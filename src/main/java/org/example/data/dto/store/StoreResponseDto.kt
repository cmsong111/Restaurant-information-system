package org.example.data.dto.store

/**
 * 가게 정보를 나타내는 DTO 클래스
 */
data class StoreResponseDto(
    val id: Long,
    val name: String,
    val callNumber: String,
    val image: String,
    val location: String,
    val category: FoodType,
    val businessHour: String,
    val description: String,
    val latitude: Double,
    val longitude: Double,
    val adminId: Long
) {
    override fun toString(): String {
        return "StoreResponseDto(id=$id, name='$name', callNumber='$callNumber', image='$image', location='$location', category=$category, businessHour='$businessHour', description='$description', latitude=$latitude, longitude=$longitude, adminId=$adminId)"
    }
}
