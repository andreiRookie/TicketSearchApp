package com.andreirookie.impl.ui.date

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andreirookie.base_decimal_formatter.DecimalFormatProvider
import com.andreirookie.impl.R

class RecommendationsAdapter(
    private val recommendations: List<RecommendationStubModel>
) : RecyclerView.Adapter<RecommendationsAdapter.RecommendationViewHolder>() {

    private val decimalFormatter = DecimalFormatProvider.provideDecimalFormat()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return RecommendationViewHolder(inflater.inflate(R.layout.recommendation_item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: RecommendationViewHolder, position: Int) {
        holder.bind(recommendations[position])
    }

    override fun getItemCount(): Int = recommendations.size

    inner class RecommendationViewHolder(
        view: View
    ) : RecyclerView.ViewHolder(view) {

        fun bind(model: RecommendationStubModel) {

            with(itemView) {
                findViewById<TextView>(R.id.airline_title).text = model.title
                findViewById<TextView>(R.id.time_range_textview).text = model.timeRange
                findViewById<TextView>(R.id.recommendation_price)
                    .text = "от ${decimalFormatter.format(model.price)} ₽"

                findViewById<ImageView>(R.id.recommendation_color_point_view)
                    .setImageResource (when (model.id) {
                        1-> com.andreirookie.uikit.R.drawable.point_red
                        2 -> com.andreirookie.uikit.R.drawable.point_blue
                        else -> com.andreirookie.uikit.R.drawable.point_white

                    })
            }
        }
    }
}