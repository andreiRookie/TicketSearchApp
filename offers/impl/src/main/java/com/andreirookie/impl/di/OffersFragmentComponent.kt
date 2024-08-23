package com.andreirookie.impl.di

import com.andreirookie.api.OffersApi
import com.andreirookie.api.di.ProvidersFacade
import com.andreirookie.impl.ui.OffersFragment
import dagger.Component

@OffersFragmentScope
@Component(
    modules = [OffersFragmentModule::class, ApiModule::class],
    dependencies = [ProvidersFacade::class]
)
interface OffersFragmentComponent : OffersApi {

    fun inject(fragment: OffersFragment)

    companion object {
        fun create(providersFacade: ProvidersFacade): OffersFragmentComponent {
            return DaggerOffersFragmentComponent
                .builder()
                .providersFacade(providersFacade)
                .build()
        }
    }
}