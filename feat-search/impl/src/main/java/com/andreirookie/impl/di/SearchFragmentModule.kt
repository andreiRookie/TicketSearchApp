package com.andreirookie.impl.di

import androidx.lifecycle.ViewModelProvider
import com.andreirookie.base_decimal_formatter.DecimalFormatProvider
import com.andreirookie.impl.network.OfferStubApiController
import com.andreirookie.impl.network.OfferStubApiControllerImpl
import com.andreirookie.impl.network.OffersApiController
import com.andreirookie.impl.reposirory.OfferMapper
import com.andreirookie.impl.reposirory.OfferMapperImpl
import com.andreirookie.impl.reposirory.OffersRepository
import com.andreirookie.impl.reposirory.OffersRepositoryImpl
import com.andreirookie.impl.reposirory.OffersStubRepositoryImpl
import com.andreirookie.impl.ui.main_search.SearchScreenViewModel
import com.andreirookie.impl.usecase.GetOffersUseCase
import com.andreirookie.impl.usecase.GetOffersUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import java.text.DecimalFormat
import javax.inject.Qualifier

@Module
interface SearchFragmentModule {

    companion object {
        @FeatureSearchScope
        @Provides
        fun provideOffersApiController(retrofit: Retrofit): OffersApiController {
            return retrofit.create(OffersApiController::class.java)
        }

        @FeatureSearchScope
        @Provides
        fun provideDecimalFormat(): DecimalFormat {
            return DecimalFormatProvider.provideDecimalFormat()
        }

    }

    @FeatureSearchScope
    @Binds
    fun bindOfferStubApiController(impl: OfferStubApiControllerImpl): OfferStubApiController

    @FeatureSearchScope
    @Binds
    fun bindOfferMapper(impl: OfferMapperImpl): OfferMapper

    @FeatureSearchScope
    @Stub
    @Binds
    fun bindOffersStubRepository(impl: OffersStubRepositoryImpl): OffersRepository

    @FeatureSearchScope
    @Api
    @Binds
    fun bindOffersRepository(impl: OffersRepositoryImpl): OffersRepository

    @FeatureSearchScope
    @Binds
    fun bindGetOffersUseCase(impl: GetOffersUseCaseImpl): GetOffersUseCase

    @FeatureSearchScope
    @Binds
    fun bindSearchScreenViewModel(impl: SearchScreenViewModel.Factory): ViewModelProvider.Factory
}

@Qualifier
annotation class Stub

@Qualifier
annotation class Api