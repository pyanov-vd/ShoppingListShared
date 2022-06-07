package com.globus.shoppinglist.shared.network.data.auth

data class LoginConfirmResponse(
    val data: MainData,
    val user_id: String
)