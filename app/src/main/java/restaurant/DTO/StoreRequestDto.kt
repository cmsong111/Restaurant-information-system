package restaurant.DTO

/**
 * 가게 등록 요청 DTO
 * @property name 가게 이름
 * @property callNumber 전화번호
 * @property image 이미지
 * @property location 위치
 * @property category 음식 종류
 * @property businessHour 영업시간
 * @property latitude 위도
 * @property longitude 경도
 * @author 김남주
 */
data class StoreRequestDto(
    val name: String,
    val callNumber: String,
    val image: String,
    val location: String,
    val category: FoodType,
    val businessHour: String,
    val description: String,
    val latitude: Double,
    val longitude: Double
) {
    override fun toString(): String {
        return "StoreRequestDto(name='$name', callNumber='$callNumber', image='$image', location='$location', category='$category', businessHour='$businessHour', latitude=$latitude, longitude=$longitude)"
    }
}
