package com.andreirookie.impl.ui.date

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andreirookie.impl.R

class DateSearchFragment : Fragment(R.layout.date_search_screen_layout) {

    private lateinit var fromWhereEditText: EditText
    private lateinit var whereEditText: EditText

    private var _recommendationsAdapter: RecommendationsAdapter? = null
    private val recommendationsAdapter: RecommendationsAdapter
        get() = _recommendationsAdapter!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _recommendationsAdapter = RecommendationsAdapter(RecommendationStubModel.recommendationsStub)

        val recyclerView = view.findViewById<RecyclerView>(R.id.ticket_recommendations_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = recommendationsAdapter

        val searchIcon = view.findViewById<ImageView>(com.andreirookie.uikit.R.id.search_icon)
        searchIcon.setImageResource(com.andreirookie.uikit.R.drawable.ic_arrow_left_24)

        fromWhereEditText = view.findViewById(com.andreirookie.uikit.R.id.from_where_edittext)
        whereEditText = view.findViewById(com.andreirookie.uikit.R.id.where_edittext)

        val fromWhereEditTextButton = view.findViewById<ImageButton>(com.andreirookie.uikit.R.id.from_where_edittext_button)
        fromWhereEditTextButton.visibility = View.VISIBLE
        fromWhereEditTextButton.setOnClickListener {
            val input = fromWhereEditText.text
            fromWhereEditText.text = whereEditText.text
            whereEditText.text = input
        }

        val whereEditTextButton = view.findViewById<ImageButton>(com.andreirookie.uikit.R.id.where_edittext_button)
        whereEditTextButton.visibility = View.VISIBLE
        whereEditTextButton.setOnClickListener {
            whereEditText.text.clear()
        }

        val showAllTicketsButton = view.findViewById<Button>(R.id.show_all_tickets_button)
        showAllTicketsButton.setOnClickListener {
            val bundle = bundleOf(
                "fromWhereArg" to fromWhereEditText.text.toString(),
                "whereArg" to whereEditText.text.toString()
            )
            findNavController()
                .navigate(com.andreirookie.navigation.R.id.action_navigate_from_date_search_screen_to_tickets_screen, bundle)
        }
    }

    override fun onStart() {
        super.onStart()

        fromWhereEditText.setText(arguments?.getString("fromWhereArg"))
        whereEditText.setText(arguments?.getString("whereArg"))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _recommendationsAdapter = null
    }

}