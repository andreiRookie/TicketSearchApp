package com.andreirookie.impl.dispatchers

import com.andreirookie.api.di.DispatchersGetter
import com.andreirookie.api.di.DispatchersProvider
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
object DispatchersModule {

    @Reusable
    @Provides
    fun provideDispatchersGetter(provider: DispatchersProvider): DispatchersGetter {
        return provider.get()
    }

    @Provides
    fun provideDispatchersProvider(): DispatchersProvider = DispatchersProviderImpl()
}

