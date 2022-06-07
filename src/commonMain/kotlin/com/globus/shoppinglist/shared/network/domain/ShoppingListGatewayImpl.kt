package com.globus.shoppinglist.shared.network.domain

import com.globus.shoppinglist.shared.network.data.ShoppingListGateway
import com.globus.shoppinglist.shared.network.data.auth.LoginConfirmResponse
import com.globus.shoppinglist.shared.network.data.auth.LoginResponse
import com.globus.shoppinglist.shared.network.data.auth.MainData
import com.globus.shoppinglist.shared.network.data.auth.User
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

/**
 * Реализация гейтвея для работы с сервером
 * @param client http-клиент
 */
class ShoppingListGatewayImpl(private val client: HttpClient) : ShoppingListGateway {

    private val apiPath = "/api/v1"
    private val tmpUserId = "b81394a1-e749-4c0d-9883-8402397c9b0f"
    private val nextTimeRequest: Long = 1654264548


    //{"phone":79261798099}
    private val loginPath = "$apiPath/auth/phone"
    override suspend fun login(phone: String): LoginResponse {
        val request = client.get {
            url { path(loginPath) }
            parameter("phone", phone)
        }
        return request.body()
    }

    // {"code":"11111","user_id":"b81394a1-e749-4c0d-9883-8402397c9b0f"}
    private val confirmPath = "$apiPath/auth/phone/confirm"
    override suspend fun smsConfirm(code: String, userId: String): LoginConfirmResponse {

        val request = client.get {
            url { path(confirmPath) }
            parameter("code", code)
            parameter("user_id", userId)
        }
        return request.body()

        /*val user = User(
            id = tmpUserId,
            name = "vlad",
            phone = 79261798099,
            email = null,
            created_at = 1653645736,
            updated_at = 1654263557,
            is_activated = true,
            is_deleted = false
        )
        return LoginConfirmResponse(
            MainData(
                access_token = "eyJhbGciOiJ",
                expires_at = 1685799557,
                user = user,
                user_id = tmpUserId
            ),
            tmpUserId
        )*/
    }
}