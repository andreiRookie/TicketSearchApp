package com.andreirookie.ticketsearch

import android.app.Application
import com.andreirookie.bridge.CoreProvidersFactory
import com.andreirookie.impl.AppContextProvider
import com.andreirookie.impl.DispatchersProvider
import com.andreirookie.impl.NetworkProvider
import com.andreirookie.impl.ProvidersFacade
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