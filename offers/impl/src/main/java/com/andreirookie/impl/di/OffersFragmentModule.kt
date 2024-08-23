package com.andreirookie.impl.di

import androidx.lifecycle.ViewModelProvider
import com.andreirookie.base_decimal_formatter.DecimalFormatProvider
import com.andreirookie.impl.data.network.OffersApiController
import com.andreirookie.impl.domain.dto.OfferMapper
import com.andreirookie.impl.domain.dto.OfferMapperImpl
import com.andreirookie.impl.domain.repository.OffersRepository
import com.andreirookie.impl.domain.repository.OffersRepositoryImpl
import com.andreirookie.impl.domain.usecase.GetOffersUseCase
import com.andreirookie.impl.domain.usecase.GetOffersUseCaseImpl
import com.andreirookie.impl.ui.OffersViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import java.text.DecimalFormat

@Module
internal interface OffersFragmentModule {

    companion object {
        @OffersFragmentScope
        @Provides
        fun provideOffersApiController(retrofit: Retrofit): OffersApiController {
            return retrofit.create(OffersApiController::class.java)
        }

        @OffersFragmentScope
        @Provides
        fun provideDecimalFormat(): DecimalFormat {
            return DecimalFormatProvider.provideDecimalFormat()
        }
    }

    @OffersFragmentScope
    @Binds
    fun bindOfferMapper(impl: OfferMapperImpl): OfferMapper

    @OffersFragmentScope
    @Binds
    fun bindOffersRepository(impl: OffersRepositoryImpl): OffersRepository

    @OffersFragmentScope
    @Binds
    fun bindGetOffersUseCase(impl: GetOffersUseCaseImpl): GetOffersUseCase

    @OffersFragmentScope
    @Binds
    fun bindSearchScreenViewModel(impl: OffersViewModel.Factory): ViewModelProvider.Factory
}