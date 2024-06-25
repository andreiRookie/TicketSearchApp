package com.andreirookie.ticketsearch

import android.app.Application
import com.andreirookie.api.AppContextProvider
import com.andreirookie.api.NetworkProvider
import com.andreirookie.api.ProvidersFacade
import com.andreirookie.bridge.CoreProvidersFactory
import dagger.Component


@Component(
    dependencies = [
        AppContextProvider::class,
        NetworkProvider::class
    ]
)
interface AppFacadeComponent : ProvidersFacade {

    companion object {
        fun init(app: Application): AppFacadeComponent {
            return DaggerAppFacadeComponent.builder()
                .appContextProvider(AppComponent.getComponent(app))
                .networkProvider(CoreProvidersFactory.initNetworkProvider(AppComponent.getComponent(app)))
                .build()
        }
    }
}