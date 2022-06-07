package com.globus.shoppinglist.shared.network.core

import io.ktor.client.engine.*
import io.ktor.client.engine.darwin.*

actual class HttpEngineFactory {
    actual fun createEngine(): HttpClientEngineFactory<HttpClientEngineConfig> {
        return Darwin
    }
}