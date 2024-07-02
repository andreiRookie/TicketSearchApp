package com.andreirookie.impl.ui.tickets.delegate

import com.andreirookie.impl.ui.tickets.TicketStubModel

fun List<TicketStubModel>.asDelegateItemList(): List<DelegateItem> {
    return this.map { model ->
        TicketDelegateItemModel(
            id = model.id,
            value = model
        )
    }
}