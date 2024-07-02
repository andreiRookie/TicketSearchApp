package com.andreirookie.impl.ui.tickets.delegate

import com.andreirookie.impl.ui.tickets.TicketStubModel

class TicketDelegateItemModel(
    val id: Int,
    private val value: TicketStubModel
) : DelegateItem {
    override fun id(): Int = id

    override fun content(): Any = value

    override fun compareWithAnother(item: DelegateItem): Boolean {
        return (item as TicketDelegateItemModel).value == content()
    }
}