package com.andreirookie.impl

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.MainCoroutineDispatcher

interface DispatchersGetter {
    val main: MainCoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
}