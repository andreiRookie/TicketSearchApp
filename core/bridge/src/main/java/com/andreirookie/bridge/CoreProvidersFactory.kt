package com.andreirookie.bridge

import com.andreirookie.api.di.AppContextProvider
import com.andreirookie.api.di.DispatchersProvider
import com.andreirookie.api.di.NetworkProvider
import com.andreirookie.impl.dispatchers.DaggerDispatchersProviderComponent
import com.andreirookie.impl.network.DaggerNetworkComponent

object CoreProvidersFactory {

    fun initNetworkProvider(appContextProvider: AppContextProvider): NetworkProvider {
        return DaggerNetworkComponent.builder().appContextProvider(appContextProvider).build()

    }

    fun initDispatchersProvider(appContextProvider: AppContextProvider): DispatchersProvider {
        return DaggerDispatchersProviderComponent.builder().appContextProvider(appContextProvider).build()
    }
}