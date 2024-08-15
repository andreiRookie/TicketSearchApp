package com.andreirookie.impl.network

import com.andreirookie.impl.DispatchersGetter
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainCoroutineDispatcher

class DispatchersGetterImpl : DispatchersGetter {

    override fun main(): MainCoroutineDispatcher {
        return Dispatchers.Main
    }

    override fun io(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    override fun default(): CoroutineDispatcher {
        return Dispatchers.Default
    }
}
