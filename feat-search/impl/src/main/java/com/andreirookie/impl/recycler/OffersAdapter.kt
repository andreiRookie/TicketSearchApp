package com.andreirookie.impl.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andreirookie.base_decimal_formatter.DecimalFormatProvider
import com.andreirookie.impl.R
import com.andreirookie.impl.network.OfferItemApiModel

class OffersAdapter(
    private val offers: List<OfferItemApiModel>
) : RecyclerView.Adapter<OffersAdapter.OfferViewHolder>() {

    private val decimalFormatter = DecimalFormatProvider.provideDecimalFormat()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return OfferViewHolder(inflater.inflate(R.layout.offer_item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
       holder.bind(offers[position])
    }

    override fun getItemCount(): Int {
        return offers.size
    }

    inner class OfferViewHolder(
        view: View
    ) : RecyclerView.ViewHolder(view) {

        private val image = view.findViewById<ImageView>(R.id.offer_image)
        private val title = view.findViewById<TextView>(R.id.offer_title_textview)
        private val price = view.findViewById<TextView>(R.id.offer_price_textview)
        private val town = view.findViewById<TextView>(R.id.offer_town_textview)

        fun bind(model: OfferItemApiModel) {

            title.text = model.title
            town.text = model.town
            val formattedPrice = decimalFormatter.format(model.price.value)
            price.text = "от $formattedPrice ₽"

            val imageRes = when (model.id) {
                1 -> { R.drawable.img_offer_1 }
                2 -> { R.drawable.img_offer_2 }
                else -> { R.drawable.img_offer_3 }
            }
            image.setImageResource(imageRes)
        }
    }
}

