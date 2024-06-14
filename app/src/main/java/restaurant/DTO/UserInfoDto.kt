package restaurant.DTO


data class UserInfoDto(
    val id: Long,
    val name: String,
    val email: String,
    val role: MutableList<String>,
    val stores: MutableList<String>,
    val review: MutableList<String>
) {
    override fun toString(): String {
        return "UserInfoDto(id=$id, name='$name', email='$email', roles=$role, stores=$stores, review=$review)"
    }
}
