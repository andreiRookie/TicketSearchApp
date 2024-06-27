package com.andreirookie.impl

import android.content.Context
import android.os.Bundle
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
import com.andreirookie.impl.di.SearchFragmentComponent
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchFragment : Fragment() {

    private lateinit var fromEdittext: EditText
    private lateinit var toEdittext: EditText
    private lateinit var progressBar: ProgressBar

    @Inject
    lateinit var vmFactory: SearchScreenViewModel.Factory
    private val viewModel: SearchScreenViewModel by viewModels { vmFactory }

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

        fromEdittext = view.findViewById(com.andreirookie.uikit.R.id.from_edittext)
        toEdittext = view.findViewById(com.andreirookie.uikit.R.id.to_edittext)
        progressBar = view.findViewById(R.id.progress_bar)

        fromEdittext.hint = getString(R.string.search_screen_from_edittext_hint)
        toEdittext.hint = getString(R.string.search_screen_to_edittext_hint)

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.offersStateFlow.collect {
                    handleState(it)
                }
            }
        }
    }

    private fun handleState(state: OffersState) {
        when (state) {
            OffersState.Loading -> {
                progressBar.visibility = View.VISIBLE
            }
            is OffersState.Data -> {
//                progressBar.visibility = View.GONE
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