package com.globus.shoppinglist.shared.network.data.auth

data class LoginResponse(
    val user_id: String,
    val next_time_request: Long
)
