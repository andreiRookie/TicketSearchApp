package com.andreirookie.api

import retrofit2.Retrofit

interface NetworkProvider {
    fun provideRetrofit(): Retrofit
}