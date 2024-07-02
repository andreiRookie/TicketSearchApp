package com.andreirookie.impl.ui.main_search

import com.andreirookie.impl.network.OfferItemApiModel
import com.andreirookie.impl.network.Price

object Stubs {
    val offers: List<OfferItemApiModel> = listOf(
        OfferItemApiModel(
            1,
            "Die Antwoord",
            "Будапешт",
            Price(22264)
        ),
        OfferItemApiModel(
            2,
            "Socrat& Lera",
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
}