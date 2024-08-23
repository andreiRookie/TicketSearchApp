package com.andreirookie.impl.usecase

import com.andreirookie.api.di.DispatchersGetter
import com.andreirookie.impl.di.Api
import com.andreirookie.impl.di.Stub
import com.andreirookie.impl.reposirory.OfferItemModel
import com.andreirookie.impl.reposirory.OffersRepository
import kotlinx.coroutines.withContext
import java.util.concurrent.CancellationException
import javax.inject.Inject

interface GetOffersUseCase {
    suspend operator fun invoke(): List<OfferItemModel>
}

class GetOffersUseCaseImpl @Inject constructor(
    @Api
    private val apiRepository: OffersRepository,
    @Stub
    private val stubRepository: OffersRepository,
    private val dispatchers: DispatchersGetter
) : GetOffersUseCase {
    override suspend operator fun invoke(): List<OfferItemModel> {
        return withContext(dispatchers.default) {
            try {
                apiRepository.getOffers()
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                stubRepository.getOffers()
            }
        }
    }
}