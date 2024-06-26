package com.andreirookie.bridge

import com.andreirookie.impl.AppContextProvider
import com.andreirookie.impl.NetworkProvider
import com.andreirookie.impl.network.DaggerNetworkComponent

object CoreProvidersFactory {

    fun initNetworkProvider(appContextProvider: AppContextProvider): NetworkProvider {
        return DaggerNetworkComponent.builder().appContextProvider(appContextProvider).build()

    }
}