package com.globus.shoppinglist.shared.network.data.auth

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val email: String? = null,
    val id: String,
    val name: String,
    val phone: Long,
    @SerialName("is_activated") val isActivated: Boolean,
    @SerialName("is_deleted") val isDeleted: Boolean,
    @SerialName("created_at") val createdAt: Long,
    @SerialName("updated_at") val updatedAt: Long
)