package com.andreirookie.activity

import com.andreirookie.impl.ProvidersFacade
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [ProvidersFacade::class]
)
interface MainActivityComponent {
    fun inject(activity: MainActivity)

    companion object {
        fun create(providersFacade: ProvidersFacade): MainActivityComponent {
            return DaggerMainActivityComponent
                .builder()
                .providersFacade(providersFacade)
                .build()
        }
    }
}