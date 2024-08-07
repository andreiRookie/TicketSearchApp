package com.andreirookie.impl.ui.main_search

import android.content.Context
import android.os.Bundle
import android.text.InputFilter
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andreirookie.base_cyrillic_validation.CyrillicInputFilter
import com.andreirookie.impl.AppWithProvidersFacade
import com.andreirookie.impl.R
import com.andreirookie.impl.di.SearchFragmentComponent
import com.andreirookie.impl.ui.bottom.SearchBottomDialogFragment
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchFragment : Fragment() {

    private lateinit var fromWhereEditText: EditText
    private lateinit var whereEditText: EditText
    private lateinit var progressBar: ProgressBar
    private var bottomSheetDialogFragment: SearchBottomDialogFragment? = null

    @Inject
    lateinit var vmFactory: SearchScreenViewModel.Factory
    private val viewModel: SearchScreenViewModel by viewModels { vmFactory }

    private lateinit var offersAdapter: OffersAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)

        SearchFragmentComponent
            .create((requireActivity().application as AppWithProvidersFacade).provideFacade())
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        offersAdapter = OffersAdapter(Stubs.offers)
        val recyclerView = view.findViewById<RecyclerView>(R.id.offers_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = offersAdapter

        fromWhereEditText = view.findViewById(com.andreirookie.uikit.R.id.from_where_edittext)
        whereEditText = view.findViewById(com.andreirookie.uikit.R.id.where_edittext)
        progressBar = view.findViewById(R.id.progress_bar)

        fromWhereEditText.hint = getString(R.string.search_screen_from_edittext_hint)
        fromWhereEditText.inputType = InputType.TYPE_CLASS_TEXT
        fromWhereEditText.filters = arrayOf<InputFilter>(CyrillicInputFilter())

        whereEditText.hint = getString(R.string.search_screen_to_edittext_hint)
        whereEditText.inputType = InputType.TYPE_NULL
        whereEditText.focusable = View.NOT_FOCUSABLE
        whereEditText.filters = arrayOf<InputFilter>(CyrillicInputFilter())

        whereEditText.setOnClickListener {
            if (bottomSheetDialogFragment == null) {
                bottomSheetDialogFragment = SearchBottomDialogFragment()
            }

            bottomSheetDialogFragment?.putInputArg(fromWhereEditText.text.toString())
            bottomSheetDialogFragment?.show(parentFragmentManager, SearchBottomDialogFragment.TAG)
        }

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.offersStateFlow.collect {
                    handleState(it)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bottomSheetDialogFragment = null
    }

    private fun handleState(state: OffersState) {
        when (state) {
            OffersState.Loading -> {
                progressBar.visibility = View.VISIBLE
            }
            is OffersState.Data -> {
                progressBar.visibility = View.GONE
                println(state.offers)
            }
            is OffersState.Error -> {
                progressBar.visibility = View.GONE
            }
            OffersState.Init -> {
                progressBar.visibility = View.GONE

            }
        }
    }
}