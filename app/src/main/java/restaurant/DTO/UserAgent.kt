package restaurant.DTO

import com.fasterxml.jackson.annotation.JsonProperty

data class UserAgent(
    val product: String,
    val version: String,
    val comment: String,
    @JsonProperty("raw_value")
    val rawValue: String,
)
