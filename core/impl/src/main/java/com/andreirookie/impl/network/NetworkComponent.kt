package com.andreirookie.impl.network

import com.andreirookie.impl.AppContextProvider
import com.andreirookie.impl.NetworkProvider
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    dependencies = [AppContextProvider::class],
    modules = [NetworkModule::class]
)
interface NetworkComponent : NetworkProvider