package com.andreirookie.impl.di

import com.andreirookie.api.OffersApi

interface SearchScreenInnerApiProvider {
    fun getOffersApi(): OffersApi
}