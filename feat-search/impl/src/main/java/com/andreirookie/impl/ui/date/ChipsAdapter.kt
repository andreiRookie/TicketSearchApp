package com.andreirookie.impl.ui.date

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ChipsAdapter(
    private val chips: List<ChipStubModel>
) : RecyclerView.Adapter<ChipsAdapter.ChipViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChipViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = chips.size

    override fun onBindViewHolder(holder: ChipViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class ChipViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(chip: ChipStubModel) {

        }

    }
}
