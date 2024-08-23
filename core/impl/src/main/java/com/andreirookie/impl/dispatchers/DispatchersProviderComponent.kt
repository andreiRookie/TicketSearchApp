package com.andreirookie.impl.dispatchers

import com.andreirookie.api.di.AppContextProvider
import com.andreirookie.api.di.DispatchersProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [AppContextProvider::class],
    modules = [DispatchersModule::class]
)
interface DispatchersProviderComponent : DispatchersProvider