package org.example.data.dto.ifconfig

import com.google.gson.annotations.SerializedName


/**
 * IP 정보 조회(위치 정보 조회)
 */
data class Ifconfig(
    /**
     * IP 주소
     */
    val ip: String,
    /**
     * IP 주소(10진수)
     */
    @SerializedName("ip_decimal")
    val ipDecimal: Long,
    /**
     * 국가명
     */
    val country: String,
    /**
     * 국가 코드
     */
    @SerializedName("country_iso")
    val countryIso: String,
    /**
     * EU 국가 여부
     */
    @SerializedName("country_eu")
    val countryEu: Boolean,
    /**
     * 지역명
     */
    @SerializedName("region_name")
    val regionName: String,
    /**
     * 지역 코드
     */
    @SerializedName("region_code")
    val regionCode: String,
    /**
     * 우편번호
     */
    @SerializedName("zip_code")
    val zipCode: String,
    /**
     * 도시명
     */
    val city: String,
    /**
     * 위도
     */
    val latitude: Double,
    /**
     * 경도
     */
    val longitude: Double,
    /**
     * 시간대
     */
    @SerializedName("time_zone")
    val timeZone: String,
    val asn: String,
    @SerializedName("asn_org")
    val asnOrg: String,
    /**
     * User Agent 정보
     */
    @SerializedName("user_agent")
    val userAgent: UserAgent,
)
