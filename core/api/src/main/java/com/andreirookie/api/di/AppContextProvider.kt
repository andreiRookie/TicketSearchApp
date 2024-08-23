package com.andreirookie.api.di

import android.content.Context

interface AppContextProvider {
    fun provideContext(): Context
}