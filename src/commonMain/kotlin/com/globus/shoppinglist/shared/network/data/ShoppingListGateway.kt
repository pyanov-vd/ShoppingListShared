package com.globus.shoppinglist.shared.network.data

import com.globus.shoppinglist.shared.network.data.auth.LoginConfirmResponse
import com.globus.shoppinglist.shared.network.data.auth.LoginResponse

/**
 * Гейтвей для работы с АПИ Шопинглиста
 */
interface ShoppingListGateway {

    /**
     * Авторизация в приложении
     *
     * @param phone номер телефона
     * @return [LoginResponse]
     */
    suspend fun login(phone: String): LoginResponse

    /**
     * Подтверждение по смс
     * @param code смс код
     * @param userId идентификатор юзера
     * @return [LoginConfirmResponse]
     */
    suspend fun smsConfirm(code: String, userId: String): LoginConfirmResponse
}