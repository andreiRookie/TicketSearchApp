package com.andreirookie.impl.network

import com.andreirookie.impl.AppContextProvider
import com.andreirookie.impl.DispatchersProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [AppContextProvider::class],
    modules = [DispatchersModule::class]
)
interface DispatchersProviderComponent : DispatchersProvider