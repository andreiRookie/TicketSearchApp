package com.andreirookie.impl

import retrofit2.Retrofit

interface NetworkProvider {
    fun provideRetrofit(): Retrofit
}