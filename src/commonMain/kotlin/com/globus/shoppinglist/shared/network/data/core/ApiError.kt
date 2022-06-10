package com.globus.shoppinglist.shared.network.data.core

import kotlinx.serialization.Serializable

@Serializable
data class ApiError(
    val code: Int = 0,
    val message: String = "Default message for code = $code"
)