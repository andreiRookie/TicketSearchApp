package com.andreirookie.impl.ui.tickets

data class TicketStubModel(
    val id: Int,
    val badge: String? = null,
    val price: String,
    val departure: Departure,
    val arrival: Arrival,
    val hasTransfer: Boolean
) {
    companion object {
        val tickets = listOf<TicketStubModel>(
            TicketStubModel(
                id = 1,
                badge = "Самый удобный",
                price = "6 990",
                departure = Departure("03:15", "VKO"),
                arrival = Arrival("07:10", "AER"),
                hasTransfer = true
            ),
            TicketStubModel(
                id = 2,
                badge = "Прилет вечером",
                price = "8 566",
                departure = Departure("17:45", "DME"),
                arrival = Arrival("21:20", "AER"),
                hasTransfer = true
            ),
            TicketStubModel(
                id = 3,
                price = "7 386",
                departure = Departure("12:00", "DME"),
                arrival = Arrival("15:35", "AER"),
                hasTransfer = true
            ),
            TicketStubModel(
                id = 4,
                price = "7 777",
                departure = Departure("15:00", "VKO"),
                arrival = Arrival("18:35", "AER"),
                hasTransfer = true
            ),
            TicketStubModel(
                id = 5,
                price = "9 800",
                departure = Departure("03:15", "VKO"),
                arrival = Arrival("07:10", "AER"),
                hasTransfer = false
            ),
            TicketStubModel(
                id = 6,
                price = "9 990",
                departure = Departure("03:15", "DME"),
                arrival = Arrival("07:10", "AER"),
                hasTransfer = false
            )
        )
    }
}

data class Departure(
    val date: String,
    val airport: String
)

data class Arrival(
    val date: String,
    val airport: String
)


