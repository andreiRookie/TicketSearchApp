package com.andreirookie.impl.domain.dto

import com.andreirookie.impl.data.network.OfferItemApiModel
import java.text.DecimalFormat
import javax.inject.Inject

interface OfferMapper {
    fun map(apiModel: OfferItemApiModel): OfferItemModel
}

class OfferMapperImpl @Inject constructor(
    private val decimalFormat: DecimalFormat
) : OfferMapper {
    override fun map(apiModel: OfferItemApiModel): OfferItemModel {
        return with(apiModel) {
            OfferItemModel(
                id = id,
                title = title,
                town = town,
                price = decimalFormat.format(price.value)
            )
        }
    }
}