package com.andreirookie.impl.network

import com.andreirookie.impl.DispatchersGetter
import com.andreirookie.impl.DispatchersProvider
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

