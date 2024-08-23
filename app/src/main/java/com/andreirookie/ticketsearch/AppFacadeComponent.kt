package com.andreirookie.ticketsearch

import android.app.Application
import com.andreirookie.api.di.AppContextProvider
import com.andreirookie.api.di.DispatchersProvider
import com.andreirookie.api.di.NetworkProvider
import com.andreirookie.api.di.ProvidersFacade
import com.andreirookie.bridge.CoreProvidersFactory
import dagger.Component


@Component(
    dependencies = [
        AppContextProvider::class,
        NetworkProvider::class,
        DispatchersProvider::class
    ]
)
interface AppFacadeComponent : ProvidersFacade {

    companion object {
        fun init(app: Application): AppFacadeComponent {
            return DaggerAppFacadeComponent.builder()
                .appContextProvider(AppComponent.getComponent(app))
                .networkProvider(CoreProvidersFactory.initNetworkProvider(AppComponent.getComponent(app)))
                .dispatchersProvider(CoreProvidersFactory.initDispatchersProvider(AppComponent.getComponent(app)))
                .build()
        }
    }
}