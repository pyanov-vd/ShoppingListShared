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
 *
 * [Deprecated] @see [SLSDK]
 */
@Deprecated("Закрыл этот класс потмоу, что не может инициализироваться нормально")
@ThreadLocal
object SoppingListSDK {

    private val di: DirectDI
        get() = requireNotNull(_di)
    private var _di: DirectDI? = null

    /**
     * Инициализация конфигурации и провайдинг зависимостей
     */
    fun init(configuration: Configuration) {
        val configurationModule = DI.Module("ConfigurationModule") {
            bindSingleton { configuration }
        }

        if (_di != null) {
            _di = null
        }

        val direct = DI {
            importAll(
                configurationModule,
                ktorModule,
                repositoryModule
            )
        }.direct

        _di = direct
    }

    val authInteractor: AuthInteractor = di.instance()
}