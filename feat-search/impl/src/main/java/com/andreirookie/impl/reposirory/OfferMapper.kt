package com.andreirookie.impl.reposirory

import com.andreirookie.impl.network.OfferItemApiModel
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