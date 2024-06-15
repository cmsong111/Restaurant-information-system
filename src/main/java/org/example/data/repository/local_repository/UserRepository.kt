package org.example.data.repository.local_repository

import org.example.data.dto.ifconfig.Ifconfig
import org.example.data.dto.user.UserInfoDto

/**
 * 인증 정보를 저장하는 싱글톤 객체

 */
object UserRepository {
    var email: String? = null
    var password: String? = null

    var user: UserInfoDto? = null
    var token: String? = null

    var location: Ifconfig? = null
}
