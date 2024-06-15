package org.example.controller

import org.example.common.logger
import org.example.data.dto.store.FoodType
import org.example.data.dto.store.StoreHeaderDto
import org.example.data.dto.store.StoreResponseDto
import org.example.data.repository.local_repository.UserLocalRepository
import org.example.data.repository.remote_repository.RetrofitProvider
import org.example.data.repository.remote_repository.StoreRemoteRepository
import org.example.view.auth.EditUserPage
import org.example.view.auth.LoginPage
import org.example.view.components.LoadingFrame
import org.example.view.store.MainPage
import retrofit2.Response
import javax.swing.JFrame

class MainPageController(
    private val mainPage: MainPage
) {
    private val storeRemoteRepository: StoreRemoteRepository = RetrofitProvider.storeRetrofit


    /**
     *  주소 검색
     */
    var selectedLocation: String? = null

    /**
     * 음식점 종류
     */
    var category: FoodType? = null

    /**
     * 지역 화폐 사용 여부
     */
    var localCurrency: Boolean = false

    /**
     * 아동 급식 카드
     */
    var forChild: Boolean = false

    /**
     * 모범 음식점
     */
    var roleModel: Boolean = false


    /**
     * 메인 페이지로 이동
     */
    fun moveToMainPage() {
        mainPage.dispose()
        MainPage()
    }

    /**
     * 현재 조건으로 가게 검색
     */
    fun searchStore() {
        val loadingFrame: JFrame = LoadingFrame()
        val response: Response<MutableList<StoreHeaderDto>> = storeRemoteRepository.getStoreList().execute()

        if (response.isSuccessful) {
            logger.info { "랜덤 가게 추천 성공" }
            logger.info { response.body() }
        } else {
            logger.error { "랜덤 가게 추천 실패" }
        }
        loadingFrame.dispose()
    }

    /**
     * 랜덤 가게 추천
     */
    fun randomStore() {
        val loadingFrame: JFrame = LoadingFrame()
        val response: Response<StoreResponseDto> = storeRemoteRepository.getRandomStore().execute()

        if (response.isSuccessful) {
            logger.info { "랜덤 가게 추천 성공" }
            logger.info { response.body() }
        } else {
            logger.error { "랜덤 가게 추천 실패" }
        }
        loadingFrame.dispose()
    }

    /**
     * 개인정보 수정
     */
    fun modifyUserInfo() {
        EditUserPage()
    }

    /**
     * 로그아웃
     */

    fun logout() {
        UserLocalRepository.user = null
        UserLocalRepository.token = null
        LoginPage()
        mainPage.dispose()
    }


}
