package com.andreirookie.impl.reposirory

import com.andreirookie.impl.di.IO
import com.andreirookie.impl.network.OfferStubApiController
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface OffersStubRepository {
    suspend fun getOffers(): List<OfferItemModel>
}

class OffersStubRepositoryImpl @Inject constructor(
    private val stubApiController: OfferStubApiController,
    private val mapper: OfferMapper,
    @IO
    private val dispatcher: CoroutineDispatcher
) : OffersStubRepository {

    override suspend fun getOffers(): List<OfferItemModel> {
        return withContext(dispatcher) {
            stubApiController.getOffers().offers
                .map { apiModel ->
                    mapper.map(apiModel)
                }
        }
    }
}