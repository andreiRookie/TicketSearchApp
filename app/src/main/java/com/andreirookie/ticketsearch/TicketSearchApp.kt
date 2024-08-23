package com.andreirookie.ticketsearch

import android.app.Application
import com.andreirookie.api.OffersApi
import com.andreirookie.api.di.AppWithProvidersFacade
import com.andreirookie.api.di.ProvidersFacade
import com.andreirookie.impl.di.OffersFragmentComponent
import com.andreirookie.impl.di.SearchScreenInnerApiProvider

class TicketSearchApp : Application(), AppWithProvidersFacade, SearchScreenInnerApiProvider {


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

    override fun getOffersApi(): OffersApi {
        return OffersFragmentComponent.create(provideFacade())
    }
}