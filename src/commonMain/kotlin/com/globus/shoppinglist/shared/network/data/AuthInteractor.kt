package com.globus.shoppinglist.shared.network.data

import com.globus.shoppinglist.shared.network.data.auth.LoginConfirmResponse
import com.globus.shoppinglist.shared.network.data.auth.LoginResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Интерактор юзкейсов авторизации
 *
 * @property repository репозиторый работы с сетью
 */
class AuthInteractor(private val repository: ShoppingListGateway) {

    private val dispatcher: CoroutineDispatcher = Dispatchers.Default

    /**
     * Вход по номеру телефона
     */
    suspend fun loginByPhone(phone: Long): LoginResponse? {
        return withContext(dispatcher) {
            repository.login(phone).data
        }
    }

    /**
     * Подтверждение по смс
     */
    suspend fun smsConfirm(code: String, userId: String): LoginConfirmResponse? {
        return withContext(dispatcher) {
            repository.smsConfirm(code, userId).data
        }
    }
}