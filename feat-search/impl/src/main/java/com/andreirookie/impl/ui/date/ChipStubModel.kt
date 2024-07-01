package com.andreirookie.impl.ui.date


data class ChipStubModel(
    val iconRes: Int? = null,
    val text: String
) {
    companion object {
        val chips = listOf(
            ChipStubModel(
                iconRes = com.andreirookie.uikit.R.drawable.ic_plus_16,
                text = "обратно"
            ),
            ChipStubModel(
                text = "24 фев, сб"
            ),
            ChipStubModel(
                iconRes = com.andreirookie.uikit.R.drawable.ic_person_16,
                text = "1, эконом"
            ),
            ChipStubModel(
                iconRes = com.andreirookie.uikit.R.drawable.ic_filters_16,
                text = "фильтры"
            )
        )
    }
}
