package com.globus.shoppinglist.shared.di

import com.globus.shoppinglist.shared.network.data.ShoppingListGateway
import com.globus.shoppinglist.shared.network.domain.ShoppingListGatewayImpl
import io.ktor.client.*
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance

/**
 * Модуль провайдинга репозиториев
 */
val repositoryModule = DI.Module("RepositoryModule") {

    /**
     * Провайдим репозиторий для работы с сетью
     */
    bindSingleton<ShoppingListGateway> { ShoppingListGatewayImpl(instance<HttpClient>()) }

}