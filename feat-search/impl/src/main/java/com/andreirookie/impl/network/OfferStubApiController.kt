package com.andreirookie.impl.network

import kotlinx.coroutines.delay
import javax.inject.Inject

interface OfferStubApiController {
    suspend fun getOffers(): OffersApiResponse
}

class OfferStubApiControllerImpl @Inject constructor() : OfferStubApiController {

    override suspend fun getOffers(): OffersApiResponse {
        delay(3000)
        return offersResponse
    }

    private val offersResponse: OffersApiResponse = OffersApiResponse(
        listOf(
            OfferItemApiModel(
                1,
                "Die Antwoord",
                "Будапешт",
                Price(22264)
            ),
            OfferItemApiModel(
                2,
                "Socrat & Lera",
                "Санкт-Петербург",
                Price(2390)
            ),
            OfferItemApiModel(
                3,
                "Лампабикт",
                "Москва",
                Price(2390)
            )
        )
    )
}