package com.andreirookie.impl.ui.date

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment
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
        searchIcon.setImageResource(com.andreirookie.uikit.R.drawable.ic_left_arrow_24)

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


//        val dividerDrawable = AppCompatResources.getDrawable(requireContext(), com.andreirookie.uikit.R.drawable.divider)
//        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL).apply {
//            dividerDrawable?.let { setDrawable(it) }
//        })

//        val chipGroup = view.findViewById<ChipGroup>(R.id.chip_group)
//        ChipStubModel.chips.forEach { model ->
//            val chip = LayoutInflater.from(requireActivity())
//                .inflate(com.andreirookie.uikit.R.layout.chip_item_layout, null) as Chip
//            chip.id
//            chip.text = model.text
//            model.iconRes?.let { chip.setChipIconResource(it) }
//            chipGroup.addView(chip)
//        }
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