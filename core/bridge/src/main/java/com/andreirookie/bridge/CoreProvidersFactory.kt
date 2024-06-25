package com.andreirookie.bridge

import com.andreirookie.api.AppContextProvider
import com.andreirookie.api.NetworkProvider
import com.andreirookie.impl.network.DaggerNetworkComponent

object CoreProvidersFactory {

    fun initNetworkProvider(appContextProvider: AppContextProvider): NetworkProvider {
        return DaggerNetworkComponent.builder().appContextProvider(appContextProvider).build()

    }
}