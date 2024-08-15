package com.andreirookie.impl.network

import com.andreirookie.impl.DispatchersGetter
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainCoroutineDispatcher

class DispatchersGetterImpl : DispatchersGetter {

    override val main: MainCoroutineDispatcher = Dispatchers.Main

    override val io: CoroutineDispatcher = Dispatchers.IO

    override val default: CoroutineDispatcher = Dispatchers.Default
}
