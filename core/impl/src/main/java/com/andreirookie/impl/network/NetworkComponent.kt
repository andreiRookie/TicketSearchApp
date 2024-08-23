package com.andreirookie.impl.network

import com.andreirookie.api.di.AppContextProvider
import com.andreirookie.api.di.NetworkProvider
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    dependencies = [AppContextProvider::class],
    modules = [NetworkModule::class]
)
interface NetworkComponent : NetworkProvider