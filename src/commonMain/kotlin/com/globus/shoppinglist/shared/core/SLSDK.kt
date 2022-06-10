package com.globus.shoppinglist.shared.core

import com.globus.shoppinglist.shared.di.ktorModule
import com.globus.shoppinglist.shared.di.repositoryModule
import com.globus.shoppinglist.shared.network.data.AuthInteractor
import io.ktor.util.reflect.*
import org.kodein.di.*
import kotlin.native.concurrent.ThreadLocal

/**
 * Класс для использования "снаружи"
 *
 * Инициализирует зависимости, провайдит объекты взаимодействия
 *
 * @see [authInteractor] - провайдим интерактор авторизации
 *
 * [ThreadLocal] - аннотация для более правильного управления памятью на iOS
 */
@ThreadLocal
object SLSDK {

    init {
        DI {
            importAll(
                ktorModule,
                repositoryModule
            )
        }
    }

    val authInteractor: AuthInteractor = DI.direct(){}.instance()
}