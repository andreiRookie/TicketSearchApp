package com.andreirookie.bridge

import com.andreirookie.impl.AppContextProvider
import com.andreirookie.impl.DispatchersProvider
import com.andreirookie.impl.NetworkProvider
import com.andreirookie.impl.network.DaggerDispatchersProviderComponent
import com.andreirookie.impl.network.DaggerNetworkComponent

object CoreProvidersFactory {

    fun initNetworkProvider(appContextProvider: AppContextProvider): NetworkProvider {
        return DaggerNetworkComponent.builder().appContextProvider(appContextProvider).build()

    }

    fun initDispatchersProvider(appContextProvider: AppContextProvider): DispatchersProvider {
        return DaggerDispatchersProviderComponent.builder().appContextProvider(appContextProvider).build()
    }
}