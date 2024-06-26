package com.andreirookie.impl

import android.content.Context

interface AppContextProvider {
    fun provideContext(): Context
}