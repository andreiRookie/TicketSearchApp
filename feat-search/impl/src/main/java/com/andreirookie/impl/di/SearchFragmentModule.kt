package com.andreirookie.impl.di

import androidx.lifecycle.ViewModelProvider
import com.andreirookie.impl.SearchScreenViewModel
import com.andreirookie.impl.network.OffersApiController
import com.andreirookie.impl.reposirory.OffersRepository
import com.andreirookie.impl.reposirory.OffersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
interface SearchFragmentModule {

    companion object {
        @Singleton
        @Provides
        fun provideOffersApiController(retrofit: Retrofit): OffersApiController {
            return retrofit.create(OffersApiController::class.java)
        }
    }

    @Singleton
    @Binds
    fun bindOffersRepository(impl: OffersRepositoryImpl): OffersRepository

    @Binds
    fun bindSearchScreenViewModel(impl: SearchScreenViewModel.Factory) : ViewModelProvider.Factory
}