package restaurant.DTO

import com.fasterxml.jackson.annotation.JsonProperty

data class Ifconfig(
    val ip: String,
    @JsonProperty("ip_decimal")
    val ipDecimal: Long,
    val country: String,
    @JsonProperty("country_iso")
    val countryIso: String,
    @JsonProperty("country_eu")
    val countryEu: Boolean,
    @JsonProperty("region_name")
    val regionName: String,
    @JsonProperty("region_code")
    val regionCode: String,
    @JsonProperty("zip_code")
    val zipCode: String,
    val city: String,
    val latitude: Double,
    val longitude: Double,
    @JsonProperty("time_zone")
    val timeZone: String,
    val asn: String,
    @JsonProperty("asn_org")
    val asnOrg: String,
    @JsonProperty("user_agent")
    val userAgent: UserAgent,
)
