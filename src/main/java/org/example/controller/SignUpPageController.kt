package org.example.controller

import org.example.common.logger
import org.example.data.dto.user.UserInfoDto
import org.example.data.dto.user.UserRequestDto
import org.example.data.repository.remote_repository.RetrofitProvider
import org.example.data.repository.remote_repository.UserRemoteRepository
import org.example.view.auth.LoginPage
import org.example.view.auth.SignUpPage
import org.example.view.components.LoadingFrame
import retrofit2.Response
import javax.swing.JOptionPane

class SignUpPageController(
    private val signUpPage: SignUpPage
) {
    private val userRemoteRepository: UserRemoteRepository = RetrofitProvider.userRetrofit

    fun signUp(userRequestDto: UserRequestDto) {
        logger.info { "회원가입 시도 : $userRequestDto" }
        val loadingFrame = LoadingFrame()
        val response: Response<UserInfoDto> = userRemoteRepository.register(userRequestDto).execute()

        // 회원가입 실패 시
        if (!response.isSuccessful) {
            loadingFrame.dispose()
            JOptionPane.showMessageDialog(null, "회원가입 실패")
            logger.error { "회원가입 실패 : ${response.errorBody()?.string()}" }
            return
        }

        loadingFrame.dispose()
        JOptionPane.showMessageDialog(null, "회원가입 성공")
        signUpPage.dispose()
        LoginPage()
    }
}
