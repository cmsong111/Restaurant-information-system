package org.example.data.dto

import com.google.gson.annotations.SerializedName

data class NaverApi(
    @SerializedName("X-NCP-APIGW-API-KEY-ID")
    val apiKeyId: String,

    @SerializedName("X-NCP-APIGW-API-KEY")
    val apiKey: String
) {
    override fun toString(): String {
        return "NaverApi(apiKeyId='$apiKeyId', apiKey='$apiKey')"
    }
}

