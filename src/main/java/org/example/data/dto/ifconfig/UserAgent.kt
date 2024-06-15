package org.example.data.dto.ifconfig

import com.google.gson.annotations.SerializedName


data class UserAgent(
    val product: String,
    val version: String,
    val comment: String,
    @SerializedName("raw_value")
    val rawValue: String,
)
