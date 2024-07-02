package com.andreirookie.impl.reposirory

import com.andreirookie.impl.network.OfferItemApiModel
import com.andreirookie.impl.network.OffersApiController
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


interface OffersRepository {
    suspend fun getOffers(): Flow<List<OfferItemApiModel>
            >
}

class OffersRepositoryImpl @Inject constructor(
    private val apiController: OffersApiController
) : OffersRepository {
    override suspend fun getOffers(): Flow<List<OfferItemApiModel>> {
        return  flow { apiController.getOffers().offers }
    }


}