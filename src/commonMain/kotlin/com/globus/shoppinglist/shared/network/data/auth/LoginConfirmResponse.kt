package com.globus.shoppinglist.shared.network.data.auth

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginConfirmResponse(
    val data: AuthMainData,
    @SerialName("user_id") val userId : String
)