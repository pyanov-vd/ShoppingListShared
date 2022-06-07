package com.globus.shoppinglist.shared.di

import com.globus.shoppinglist.shared.network.core.HttpEngineFactory
import com.globus.shoppinglist.shared.network.core.provideHttpClient
import io.ktor.client.*
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance

/**
 * Модуль для провайда движка Ktor
 */
internal val ktorModule = DI.Module("KtorModule") {

    /**
     * Провайдим фабрику для движка
     * @see [HttpEngineFactory]
     */
    bindSingleton<HttpEngineFactory> { HttpEngineFactory() }

    /**
     * Провайдим [HttpClient] - клиент для работы с сетью
     */
    bindSingleton<HttpClient> {
        val factory = instance<HttpEngineFactory>().createEngine()
        provideHttpClient(factory)
    }
}