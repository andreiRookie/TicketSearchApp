package com.andreirookie.impl.di

import com.andreirookie.impl.ProvidersFacade
import com.andreirookie.impl.ui.main_search.SearchFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [ProvidersFacade::class],
    modules = [SearchFragmentModule::class]
)
interface SearchFragmentComponent {

    fun inject(fragment: SearchFragment)

    companion object {
        fun create(providersFacade: ProvidersFacade): SearchFragmentComponent {
            return DaggerSearchFragmentComponent
                .builder()
                .providersFacade(providersFacade)
                .build()
        }
    }
}