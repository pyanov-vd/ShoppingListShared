package com.globus.shoppinglist.shared.network.core

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*

private const val baseUrlDev = "shoppinglist.dev.globus-ltd.com"
private val mainProtocol = URLProtocol.HTTPS

/**
 * Провайдим движок для работы с сетью
 *
 * @param engineFactory платформозависимая фабрика для сетевого клиента @see [HttpEngineFactory]
 * @return [HttpClient]
 */
fun <T : HttpClientEngineConfig> provideHttpClient(
    engineFactory: HttpClientEngineFactory<T>
): HttpClient {

    return HttpClient(engineFactory) {
        //todo: разобраться с этим местом
        //serialization - начиная с ktor 2.0 сериализация существует в стандартном виде
        //пока непонятно, надо ли прибегать к сериализации с помощью kotlinx.serialization
        install(ContentNegotiation)

        install(Logging) {
            logger = Logger.SIMPLE
            level = LogLevel.ALL
        }

        defaultRequest {
            host = baseUrlDev
            url {
                protocol = mainProtocol
            }
        }
    }
}