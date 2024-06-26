package com.andreirookie.ticketsearch

import android.app.Application
import com.andreirookie.impl.AppContextProvider
import com.andreirookie.impl.NetworkProvider
import com.andreirookie.impl.ProvidersFacade
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