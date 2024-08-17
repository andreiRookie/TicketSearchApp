package com.andreirookie.impl.reposirory

import com.andreirookie.impl.DispatchersGetter
import com.andreirookie.impl.network.OfferStubApiController
import com.andreirookie.impl.network.OffersApiController
import kotlinx.coroutines.withContext
import javax.inject.Inject


interface OffersRepository {
    suspend fun getOffers(): List<OfferItemModel>
}

class OffersRepositoryImpl @Inject constructor(
    private val apiController: OffersApiController,
    private val mapper: OfferMapper
) : OffersRepository {
    override suspend fun getOffers(): List<OfferItemModel> {
        return apiController.getOffers().offers
            .map { apiModel -> mapper.map(apiModel) }
    }
}

class OffersStubRepositoryImpl @Inject constructor(
    private val stubApiController: OfferStubApiController,
    private val mapper: OfferMapper,
    private val dispatcher: DispatchersGetter
) : OffersRepository {

    override suspend fun getOffers(): List<OfferItemModel> {
        return withContext(dispatcher.io) {
            stubApiController.getOffers().offers
                .map { apiModel ->
                    mapper.map(apiModel)
                }
        }
    }
}