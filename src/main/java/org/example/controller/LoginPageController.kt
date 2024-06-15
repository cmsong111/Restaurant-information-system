package org.example.controller

import org.example.data.dto.user.UserInfoDto
import org.example.data.repository.local_repository.UserRepository
import org.example.data.repository.remote_repository.RetrofitProvider
import org.example.data.repository.remote_repository.UserRemoteRepository
import org.example.view.auth.LoginPage
import org.example.view.auth.SignUpPage
import org.example.view.store.MainPage
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import retrofit2.Response
import javax.swing.JOptionPane

class LoginPageController(
    private var loginPage: LoginPage
) {
    private val userRemoteRepository: UserRemoteRepository = RetrofitProvider.userRetrofit
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    /**
     *  로그인
     */
    fun login(email: String, password: String) {
        logger.info("로그인 시도 : ID: $email, PW: $password")

        // 로그인 요청 API 호출
        val response = userRemoteRepository.login(email, password).execute()
        if (!response.isSuccessful) {
            JOptionPane.showMessageDialog(null, "로그인 실패")
            return
        }
        // 로그인 성공 시 정보 저장
        UserRepository.email = email
        UserRepository.password = password
        UserRepository.token = "Bearer ${response.body()?.token}"

        // 유저 정보 조회
        val userResponse: Response<UserInfoDto> = userRemoteRepository.getUser(UserRepository.token!!).execute()
        if (!userResponse.isSuccessful) {
            JOptionPane.showMessageDialog(null, "사용자 정보 조회 실패")
            return
        }
        // 사용자 정보 저장
        logger.info("로그인 성공 : ${userResponse.body()}")
        UserRepository.user = userResponse.body()

        // 메인 페이지로 이동
        MainPage()
        loginPage.dispose()
    }

    /**
     * 회원가입 페이지로 이동

     */
    fun register() {
        logger.info("회원가입 페이지로 이동")
        SignUpPage()
        loginPage.dispose()
    }
}
