package com.andreirookie.impl.ui.tickets.delegate

import androidx.recyclerview.widget.DiffUtil

class DelegateDiffUtilItemCallback : DiffUtil.ItemCallback<DelegateItem>() {
    override fun areItemsTheSame(oldItem: DelegateItem, newItem: DelegateItem): Boolean {
        return oldItem.id() == newItem.id() &&
                oldItem::class == newItem::class
    }

    override fun areContentsTheSame(oldItem: DelegateItem, newItem: DelegateItem): Boolean {
        return oldItem.compareWithAnother(newItem)
    }
}