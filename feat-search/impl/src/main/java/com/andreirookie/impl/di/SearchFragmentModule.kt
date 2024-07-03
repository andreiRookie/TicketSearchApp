package com.andreirookie.impl.di

import androidx.lifecycle.ViewModelProvider
import com.andreirookie.base_decimal_formatter.DecimalFormatProvider
import com.andreirookie.impl.network.OfferStubApiController
import com.andreirookie.impl.network.OfferStubApiControllerImpl
import com.andreirookie.impl.ui.main_search.SearchScreenViewModel
import com.andreirookie.impl.network.OffersApiController
import com.andreirookie.impl.reposirory.OfferMapper
import com.andreirookie.impl.reposirory.OfferMapperImpl
import com.andreirookie.impl.reposirory.OffersRepository
import com.andreirookie.impl.reposirory.OffersRepositoryImpl
import com.andreirookie.impl.reposirory.OffersStubRepository
import com.andreirookie.impl.reposirory.OffersStubRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import java.text.DecimalFormat
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
interface SearchFragmentModule {

    companion object {
        @Singleton
        @Provides
        fun provideOffersApiController(retrofit: Retrofit): OffersApiController {
            return retrofit.create(OffersApiController::class.java)
        }

        @Reusable
        @Provides
        fun provideDecimalFormat(): DecimalFormat {
            return DecimalFormatProvider.provideDecimalFormat()
        }

        @IO
        @Provides
        fun providesDispatcherIo(): CoroutineDispatcher {
            return Dispatchers.IO
        }
    }

    @Singleton
    @Binds
    fun bindOfferStubApiController(impl: OfferStubApiControllerImpl): OfferStubApiController

    @Reusable
    @Binds
    fun bindOfferMapper(impl: OfferMapperImpl): OfferMapper

    @Singleton
    @Binds
    fun bindOffersStubRepository(impl: OffersStubRepositoryImpl): OffersStubRepository

    @Singleton
    @Binds
    fun bindOffersRepository(impl: OffersRepositoryImpl): OffersRepository

    @Binds
    fun bindSearchScreenViewModel(impl: SearchScreenViewModel.Factory) : ViewModelProvider.Factory
}

@Qualifier
annotation class IO