package com.globus.shoppinglist.shared.network.data.core

import com.globus.shoppinglist.shared.network.data.auth.MainData

data class BaseResponse(
    val data: MainData,
    val error: Any? = null
)