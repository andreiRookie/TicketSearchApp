package com.andreirookie.impl.ui.date

data class RecommendationStubModel(
    val id: Int,
    val title: String,
    val price: Int,
    val timeRange: String
) {
    companion object {
        val recommendationsStub = listOf(
            RecommendationStubModel(
                id = 1,
                title = "Уральские авиалинии",
                price = 2390,
                timeRange = "07:00  09:10  10:00  11:00  12:00  13:00  16:35 18:55"
            ),
            RecommendationStubModel(
                id = 2,
                title = "Победа",
                price = 2390,
                timeRange = "08:05  09:55   16:35  18:55"
            ),
            RecommendationStubModel(
                id = 3,
                title = "NordStar",
                price = 2390,
                timeRange = "13:10"
            )
        )
    }
}