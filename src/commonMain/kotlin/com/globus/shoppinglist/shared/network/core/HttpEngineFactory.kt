package com.globus.shoppinglist.shared.network.core

import io.ktor.client.engine.*

/**
 * Платформозависимая фабрика для сетевого клиента.
 * Для подробностей смотри реализации
 */
expect class HttpEngineFactory() {
    fun createEngine(): HttpClientEngineFactory<HttpClientEngineConfig>
}

