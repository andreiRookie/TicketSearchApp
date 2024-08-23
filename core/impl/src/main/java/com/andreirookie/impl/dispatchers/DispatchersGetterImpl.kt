package com.andreirookie.impl.dispatchers

import com.andreirookie.api.di.DispatchersGetter
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainCoroutineDispatcher

class DispatchersGetterImpl : DispatchersGetter {

    override val main: MainCoroutineDispatcher = Dispatchers.Main

    override val io: CoroutineDispatcher = Dispatchers.IO

    override val default: CoroutineDispatcher = Dispatchers.Default
}
