package com.andreirookie.impl.di

import com.andreirookie.api.OffersApi
import com.andreirookie.api.di.ProvidersFacade
import com.andreirookie.impl.ui.main_search.SearchFragment
import dagger.Component

@FeatureSearchScope
@Component(
    dependencies = [ProvidersFacade::class, OffersApi::class],
    modules = [SearchFragmentModule::class]
)
interface SearchFragmentComponent {

    fun inject(fragment: SearchFragment)

    companion object {
        fun create(providersFacade: ProvidersFacade): SearchFragmentComponent {
            return DaggerSearchFragmentComponent
                .builder()
                .providersFacade(providersFacade)
                .offersApi(
                    (providersFacade.provideContext().applicationContext as SearchScreenInnerApiProvider)
                        .getOffersApi())
                .build()
        }
    }
}