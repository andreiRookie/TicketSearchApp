package com.andreirookie.impl.network

import com.andreirookie.impl.DispatchersGetter
import com.andreirookie.impl.DispatchersProvider

class DispatchersProviderImpl : DispatchersProvider {
    override fun get(): DispatchersGetter {
        return DispatchersGetterImpl()
    }
}