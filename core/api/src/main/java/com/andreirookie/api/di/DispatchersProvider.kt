package com.andreirookie.api.di

interface DispatchersProvider {
    fun get(): DispatchersGetter
}