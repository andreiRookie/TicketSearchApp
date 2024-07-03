package com.andreirookie.impl.ui.main_search

import com.andreirookie.impl.reposirory.OfferItemModel

sealed interface OffersState {

    data object Loading : OffersState

    data class Data(
        val offers:List<OfferItemModel>
    ) : OffersState

    data class Error(val e: Exception): OffersState
}

