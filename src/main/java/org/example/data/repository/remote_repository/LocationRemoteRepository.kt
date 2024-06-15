package org.example.data.repository.remote_repository


import org.example.data.dto.ifconfig.Ifconfig
import retrofit2.Call
import retrofit2.http.GET

/**
 * 위치 정보를 관리하는 Repository
 */
interface LocationRemoteRepository {
    /**
     * IP 정보 조회(위치 정보 조회)
     */
    @GET("/json")
    fun getIp(): Call<Ifconfig>
}
