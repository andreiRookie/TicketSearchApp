package com.andreirookie.impl

interface DispatchersProvider {
    fun get(): DispatchersGetter
}