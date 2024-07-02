package com.andreirookie.impl.ui.tickets

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andreirookie.impl.R
import com.andreirookie.impl.ui.tickets.delegate.MainAdapter
import com.andreirookie.impl.ui.tickets.delegate.TicketAdapterDelegate
import com.andreirookie.impl.ui.tickets.delegate.asDelegateItemList

class TicketsFragment : Fragment(R.layout.tickets_screen_layout) {

    private val mainAdapter: MainAdapter by lazy { MainAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val backButton = view.findViewById<ImageView>(R.id.destination_back_button)
        backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        mainAdapter.addAdapterDelegate(TicketAdapterDelegate())

        val recycler = view.findViewById<RecyclerView>(R.id.tickets_recycler)
        recycler.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recycler.adapter = mainAdapter
        mainAdapter.submitList(TicketStubModel.tickets.asDelegateItemList())


        val destinationTitle = view.findViewById<TextView>(R.id.destination_title)
        arguments?.let {
            destinationTitle.text = getString(
                R.string.destination_title_text,
                it.getString("fromWhereArg"),
                it.getString("whereArg")
            )
        }
    }
}