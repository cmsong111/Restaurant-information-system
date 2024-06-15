package org.example.data.repository.remote_repository

import com.google.gson.Gson
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import org.example.common.logger
import org.example.data.dto.NaverApi
import org.example.data.repository.remote_repository.NaverMapAPI.naverApi
import java.awt.image.BufferedImage
import javax.imageio.ImageIO

/**
 * 네이버 지도 API 호출
 *
 * @property naverApi : 네이버 API 호출에 필요한 KEY 정보
 */
object NaverMapAPI {

    private var naverApi: NaverApi = Gson().fromJson(
        javaClass.getResource("./NaverAPI-KEY.json").readText(),
        NaverApi::class.java
    )

    /**
     * 네이버 지도 API 호출
     * @param locationX : 위도
     * @param locationY : 경도
     * @return : 지도 이미지 (BufferedImage)
     */
    fun getStaticMAP(
        locationX: Double, locationY: Double
    ): BufferedImage? {
        val client: OkHttpClient = OkHttpClient.Builder().build()
        var url: HttpUrl = HttpUrl.Builder()
            .scheme("https")
            .host("naveropenapi.apigw.ntruss.com")
            .addPathSegment("map-static")
            .addPathSegment("v2")
            .addPathSegment("raster")
            .addQueryParameter("w", "1000")
            .addQueryParameter("h", "600")
            .addQueryParameter("center", "$locationX,$locationY")
            .addQueryParameter("level", "14")
            .addQueryParameter("scale", "1")
            .addQueryParameter("markers", "pos:$locationX $locationY")
            .build()

        val request = Request.Builder()
            .url(url.toUrl())
            .addHeader("X-NCP-APIGW-API-KEY-ID", naverApi.apiKeyId)
            .addHeader("X-NCP-APIGW-API-KEY", naverApi.apiKey)
            .build()

        val response = client.newCall(request).execute()

        if (!response.isSuccessful) {
            logger.error { "NaverMapAPI 호출 실패 : ${response.body?.string()}" }
            return null
        }

        return ImageIO.read(response.body?.byteStream())
    }
}
