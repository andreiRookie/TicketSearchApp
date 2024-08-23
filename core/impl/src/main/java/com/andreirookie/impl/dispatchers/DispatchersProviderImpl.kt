package com.andreirookie.impl.dispatchers

import com.andreirookie.api.di.DispatchersGetter
import com.andreirookie.api.di.DispatchersProvider

class DispatchersProviderImpl : DispatchersProvider {
    override fun get(): DispatchersGetter {
        return DispatchersGetterImpl()
    }
}