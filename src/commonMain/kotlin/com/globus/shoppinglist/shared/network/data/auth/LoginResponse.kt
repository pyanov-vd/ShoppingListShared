package com.globus.shoppinglist.shared.network.data.auth

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    @SerialName("user_id") val userId: String,
    @SerialName("next_time_request") val nextTimeRequest: Long
)
