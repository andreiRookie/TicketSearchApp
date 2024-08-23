package com.andreirookie.api.di

import retrofit2.Retrofit

interface NetworkProvider {
    fun provideRetrofit(): Retrofit
}