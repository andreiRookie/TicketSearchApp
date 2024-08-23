package com.andreirookie.impl.domain.usecase

import com.andreirookie.api.di.DispatchersGetter
import com.andreirookie.impl.domain.dto.OfferItemModel
import com.andreirookie.impl.domain.repository.OffersRepository
import kotlinx.coroutines.withContext
import java.util.concurrent.CancellationException
import javax.inject.Inject

interface GetOffersUseCase {
    suspend operator fun invoke(): List<OfferItemModel>
}

class GetOffersUseCaseImpl @Inject constructor(
    private val apiRepository: OffersRepository,
    private val dispatchers: DispatchersGetter
) : GetOffersUseCase {

    override suspend operator fun invoke(): List<OfferItemModel> {
        return withContext(dispatchers.default) {
            try {
                apiRepository.getOffers()
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                emptyList()
            }
        }
    }
}