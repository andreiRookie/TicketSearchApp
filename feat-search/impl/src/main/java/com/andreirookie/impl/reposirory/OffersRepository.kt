package com.andreirookie.impl.reposirory

import com.andreirookie.impl.network.OfferItemApiModel
import com.andreirookie.impl.network.OffersApiController
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
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