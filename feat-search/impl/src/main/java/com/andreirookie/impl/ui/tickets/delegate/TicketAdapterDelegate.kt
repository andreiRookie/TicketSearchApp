package com.andreirookie.impl.ui.tickets.delegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andreirookie.impl.R
import com.andreirookie.impl.ui.tickets.TicketStubModel

class TicketAdapterDelegate : AdapterDelegate {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.ticket_card_layout, parent, false)
        return TicketViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        item: DelegateItem,
        position: Int
    ) {
        (holder as TicketViewHolder).bind(item.content() as TicketStubModel)
    }

    override fun isOfViewType(item: DelegateItem): Boolean {
        return item is TicketDelegateItemModel
    }

    class TicketViewHolder(
        private val view: View
    ) : RecyclerView.ViewHolder(view) {

        fun bind(model: TicketStubModel) {

            val price = view.findViewById<TextView>(R.id.ticket_price)
            price.text = model.price

            val departureTime = view.findViewById<TextView>(R.id.departure_time)
            departureTime.text = model.departure.date

            val departureAirport = view.findViewById<TextView>(R.id.departure_airport)
            departureAirport.text = model.departure.airport

            val arrivalTime = view.findViewById<TextView>(R.id.arrival_time)
            arrivalTime.text = model.arrival.date

            val arrivalAirport = view.findViewById<TextView>(R.id.arrival_airport)
            arrivalAirport.text = model.arrival.airport

            val hasTransfer = view.findViewById<TextView>(R.id.has_transfer)
            if (model.hasTransfer) {
                hasTransfer.visibility = View.INVISIBLE
            } else {
                hasTransfer.visibility = View.VISIBLE
            }

        }
    }
}