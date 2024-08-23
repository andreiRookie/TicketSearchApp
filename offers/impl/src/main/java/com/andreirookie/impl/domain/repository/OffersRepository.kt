package com.andreirookie.impl.domain.repository

import com.andreirookie.api.di.DispatchersGetter
import com.andreirookie.impl.data.network.OffersApiController
import com.andreirookie.impl.domain.dto.OfferItemModel
import com.andreirookie.impl.domain.dto.OfferMapper
import kotlinx.coroutines.withContext
import javax.inject.Inject


interface OffersRepository {
    suspend fun getOffers(): List<OfferItemModel>
}

class OffersRepositoryImpl @Inject constructor(
    private val apiController: OffersApiController,
    private val mapper: OfferMapper,
    private val dispatcher: DispatchersGetter
) : OffersRepository {
    override suspend fun getOffers(): List<OfferItemModel> {
        return withContext(dispatcher.default) {
            apiController.getOffers().offers
                .map { apiModel -> mapper.map(apiModel) }
        }
    }
}