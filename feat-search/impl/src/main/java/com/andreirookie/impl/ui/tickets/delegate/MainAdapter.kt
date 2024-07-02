package com.andreirookie.impl.ui.tickets.delegate

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class MainAdapter : ListAdapter<DelegateItem, RecyclerView.ViewHolder>(DelegateDiffUtilItemCallback()) {

    private val adapterDelegates: MutableList<AdapterDelegate> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return adapterDelegates[viewType].onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        adapterDelegates[getItemViewType(position)]
            .onBindViewHolder(holder, getItem(position), position)
    }

    override fun getItemViewType(position: Int): Int {
        return adapterDelegates.indexOfFirst {
            it.isOfViewType(currentList[position])
        }
    }

    fun addAdapterDelegate(delegate: AdapterDelegate) {
        adapterDelegates.add(delegate)
    }
}