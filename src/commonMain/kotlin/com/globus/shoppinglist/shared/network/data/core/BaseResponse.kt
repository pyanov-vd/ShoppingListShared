package com.globus.shoppinglist.shared.network.data.core

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    val data: T? = null,
    val error: ApiError? = null
)