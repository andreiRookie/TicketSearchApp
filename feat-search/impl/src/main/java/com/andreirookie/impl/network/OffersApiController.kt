package com.andreirookie.impl.network

import retrofit2.http.GET

interface OffersApiController {

    @GET(value = "v3/ad9a46ba-276c-4a81-88a6-c068e51cce3a")
    fun getOffers(): OffersApiResponse
}