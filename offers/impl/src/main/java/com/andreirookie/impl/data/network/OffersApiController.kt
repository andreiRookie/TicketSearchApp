package com.andreirookie.impl.data.network

import retrofit2.http.GET

interface OffersApiController {

    @GET(value = "/u/0/uc?id=1o1nX3uFISrG1gR-jr_03Qlu4_KEZWhav&export=download")
    suspend fun getOffers(): OffersApiResponse
}