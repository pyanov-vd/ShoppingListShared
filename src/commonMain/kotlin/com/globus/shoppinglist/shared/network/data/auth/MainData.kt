package com.globus.shoppinglist.shared.network.data.auth

data class MainData(
    val access_token: String,
    val expires_at: Long,
    val user: User,
    val user_id: String
)