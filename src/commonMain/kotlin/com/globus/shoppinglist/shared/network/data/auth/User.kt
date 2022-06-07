package com.globus.shoppinglist.shared.network.data.auth

data class User(
    val created_at: Long,
    val email: String? = null,
    val id: String,
    val is_activated: Boolean,
    val is_deleted: Boolean,
    val name: String,
    val phone: Long,
    val updated_at: Long
)