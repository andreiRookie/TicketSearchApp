package com.andreirookie.impl.reposirory

import com.andreirookie.impl.DispatchersGetter
import com.andreirookie.impl.network.OfferStubApiController
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface OffersStubRepository {
    suspend fun getOffers(): List<OfferItemModel>
}

class OffersStubRepositoryImpl @Inject constructor(
    private val stubApiController: OfferStubApiController,
    private val mapper: OfferMapper,
    private val dispatcher: DispatchersGetter
) : OffersStubRepository {

    override suspend fun getOffers(): List<OfferItemModel> {
        return withContext(dispatcher.io) {
            stubApiController.getOffers().offers
                .map { apiModel ->
                    mapper.map(apiModel)
                }
        }
    }
}