package com.andreirookie.impl.data.network

import kotlinx.serialization.Serializable

@Serializable
data class OffersApiResponse(
    val offers: List<OfferItemApiModel>
)

@Serializable
data class OfferItemApiModel(
    val id: Int,
    val title: String,
    val town: String,
    val price: Price
)

@Serializable
data class Price(
    val value: Int
)
