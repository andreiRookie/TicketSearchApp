package com.andreirookie.impl.di

import com.andreirookie.api.OffersProvider
import com.andreirookie.impl.api.OffersProviderImpl
import dagger.Binds
import dagger.Module

@Module
internal interface ApiModule {

    @OffersFragmentScope
    @Binds
    fun provideOffersProvider(impl: OffersProviderImpl): OffersProvider

}