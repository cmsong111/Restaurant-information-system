package org.example.controller

import org.example.data.repository.remote_repository.RetrofitProvider
import org.example.data.repository.remote_repository.StoreRemoteRepository
import org.example.view.store.MainPage
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class MainPageController(
    private val mainPage: MainPage
) {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    private val storeRemoteRepository: StoreRemoteRepository = RetrofitProvider.storeRetrofit

}
