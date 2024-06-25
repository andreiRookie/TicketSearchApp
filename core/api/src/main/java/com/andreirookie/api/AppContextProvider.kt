package com.andreirookie.api

import android.content.Context

interface AppContextProvider {
    fun provideContext(): Context
}