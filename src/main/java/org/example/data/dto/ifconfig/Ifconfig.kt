package org.example.data.dto.ifconfig

import com.google.gson.annotations.SerializedName


data class Ifconfig(
    val ip: String,
    @SerializedName("ip_decimal")
    val ipDecimal: Long,
    val country: String,
    @SerializedName("country_iso")
    val countryIso: String,
    @SerializedName("country_eu")
    val countryEu: Boolean,
    @SerializedName("region_name")
    val regionName: String,
    @SerializedName("region_code")
    val regionCode: String,
    @SerializedName("zip_code")
    val zipCode: String,
    val city: String,
    val latitude: Double,
    val longitude: Double,
    @SerializedName("time_zone")
    val timeZone: String,
    val asn: String,
    @SerializedName("asn_org")
    val asnOrg: String,
    @SerializedName("user_agent")
    val userAgent: UserAgent,
)
