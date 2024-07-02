package com.andreirookie.impl.ui.tickets.delegate

interface DelegateItem {

    fun id(): Int
    fun content(): Any
    fun compareWithAnother(item: DelegateItem): Boolean
}