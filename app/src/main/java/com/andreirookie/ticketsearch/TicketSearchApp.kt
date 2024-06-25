package com.andreirookie.ticketsearch

import android.app.Application
import com.andreirookie.api.AppWithProvidersFacade
import com.andreirookie.api.ProvidersFacade

class TicketSearchApp : Application(), AppWithProvidersFacade {


    override fun onCreate() {
        super.onCreate()
        provideFacade()
    }

    override fun provideFacade(): ProvidersFacade {
        return appFacadeComponent ?: AppFacadeComponent.init(this)
            .also { appFacadeComponent = it }
    }

    companion object {
        private var appFacadeComponent: AppFacadeComponent? = null
    }
}