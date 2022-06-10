package com.globus.shoppinglist.shared.network.data.auth

import kotlinx.serialization.Serializable

@Serializable
data class AuthMainData(
    val access_token: String,
    val expires_at: Long,
    val user: User,
    val user_id: String
)