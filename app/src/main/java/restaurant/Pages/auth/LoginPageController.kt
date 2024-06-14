package restaurant.Pages.auth

import restaurant.DTO.UserInfoDto
import restaurant.Setting.Auth
import restaurant.Setting.RetrofitProvider
import restaurant.api.UserRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import restaurant.Pages.MainPage
import retrofit2.Response
import javax.swing.JOptionPane

class LoginPageController(
    private var loginPage: LoginPage
) {
    private val userRepository: UserRepository = RetrofitProvider.userRetrofit
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    /**
     *  로그인
     */
    fun login(email: String, password: String) {
        logger.info("로그인 시도 : ID: $email, PW: $password")

        // 로그인 요청 API 호출
        val response = userRepository.login(email, password).execute()
        if (!response.isSuccessful) {
            JOptionPane.showMessageDialog(null, "로그인 실패")
            return
        }
        // 로그인 성공 시 정보 저장
        Auth.email = email
        Auth.password = password
        Auth.token = "Bearer ${response.body()?.token}"

        // 유저 정보 조회
        val userResponse: Response<UserInfoDto> = userRepository.getUser(Auth.token!!).execute()
        if (!userResponse.isSuccessful) {
            JOptionPane.showMessageDialog(null, "사용자 정보 조회 실패")
            return
        }
        // 사용자 정보 저장
        logger.info("로그인 성공 : ${userResponse.body()}")
        Auth.user = userResponse.body()

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
