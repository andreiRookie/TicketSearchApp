package com.andreirookie.impl.di

import com.andreirookie.impl.network.OffersApiController
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object SearchFragmentModule {

    @Singleton
    @Provides
    fun provideOffersApiController(retrofit: Retrofit): OffersApiController {
        return retrofit.create(OffersApiController::class.java)
    }
}