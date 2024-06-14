package restaurant.Setting

import restaurant.DTO.Ifconfig
import restaurant.DTO.UserInfoDto

/**
 * 인증 정보를 저장하는 싱글톤 객체

 */
object Auth {
    var email: String? = null
    var password: String? = null

    var user: UserInfoDto? = null
    var token: String? = null

    var location: Ifconfig? = null
}
