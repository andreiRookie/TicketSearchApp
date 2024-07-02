package com.andreirookie.impl.ui.main_search

import com.andreirookie.impl.network.OfferItemApiModel
import java.lang.Exception

sealed interface OffersState {

    object Init : OffersState

    object Loading : OffersState

    data class Data(
        val offers:List<OfferItemApiModel>
    ) : OffersState

    data class Error(val e: Exception): OffersState
}

