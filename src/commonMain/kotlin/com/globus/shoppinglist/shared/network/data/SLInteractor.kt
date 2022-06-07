package com.globus.shoppinglist.shared.network.data

import com.globus.shoppinglist.shared.network.data.auth.LoginConfirmResponse
import com.globus.shoppinglist.shared.network.data.auth.LoginResponse

/**
 * Интерактор основных юзкейсов
 *
 * @property repository репозиторый работы с сетью
 */
class SLInteractor(private val repository: ShoppingListGateway) {

    /**
     * Вход по номеру телефона
     */
    suspend fun loginByPhone(phone: String): LoginResponse {
        return repository.login(phone)
    }

    /**
     * Подтверждение по смс
     */
    suspend fun smsConfirm(code: String, userId: String): LoginConfirmResponse {
        return repository.smsConfirm(code, userId)
    }
}