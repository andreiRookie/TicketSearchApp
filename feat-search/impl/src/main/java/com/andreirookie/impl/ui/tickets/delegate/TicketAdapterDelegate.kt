package com.andreirookie.impl.ui.tickets.delegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.annotation.OptIn
import androidx.recyclerview.widget.RecyclerView
import com.andreirookie.impl.R
import com.andreirookie.impl.ui.tickets.TicketStubModel
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.badge.BadgeUtils
import com.google.android.material.badge.ExperimentalBadgeUtils
import com.google.android.material.card.MaterialCardView

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

        @OptIn(ExperimentalBadgeUtils::class)
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

            val ticketCard = view.findViewById<MaterialCardView>(R.id.ticket_card)
            ticketCard.setClipToOutline(false)

            model.badge?.let {
                val badgeView = initBadge()
                badgeView.text = it
                badgeView.updateBadgeCoordinates(ticketCard, itemView as FrameLayout)
//                ticketCard.overlay.add(badgeView)
                BadgeUtils.attachBadgeDrawable(badgeView, ticketCard, itemView as FrameLayout);
            }

        }

        private fun initBadge(): BadgeDrawable {
            val badgeView = BadgeDrawable.create(itemView.context)
            with(badgeView) {
                badgeTextColor = itemView.context.getColor(com.andreirookie.uikit.R.color.white)
                badgeGravity = BadgeDrawable.TOP_END
                backgroundColor = itemView.context.getColor(com.andreirookie.uikit.R.color.blue)
                horizontalOffsetWithText = -8
                verticalOffset = 64
            }
            return badgeView
        }
    }
}