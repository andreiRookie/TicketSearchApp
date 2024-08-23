package com.andreirookie.impl.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andreirookie.api.di.AppWithProvidersFacade
import com.andreirookie.api.ui.DataState
import com.andreirookie.impl.R
import com.andreirookie.impl.di.OffersFragmentComponent
import com.andreirookie.impl.domain.dto.OfferItemModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class OffersFragment : Fragment() {

    @Inject
    lateinit var vmFactory: OffersViewModel.Factory
    private val viewModel: OffersViewModel by viewModels { vmFactory }

    @Inject
    lateinit var offersAdapter: OffersAdapter

    private lateinit var progressBar: ProgressBar
    private lateinit var retryButton: Button


    override fun onAttach(context: Context) {
        super.onAttach(context)

        OffersFragmentComponent
            .create((requireActivity().application as AppWithProvidersFacade).provideFacade())
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.offers_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressBar = view.findViewById(R.id.progress_bar)
        retryButton = view.findViewById(R.id.retry_button)

        val recyclerView = view.findViewById<RecyclerView>(R.id.offers_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = offersAdapter

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.offersFlow.collect {
                    handleState(it)
                }
            }
        }
    }

    private fun handleState(state: DataState<List<OfferItemModel>>) {
        when (state) {
            is DataState.Loading -> {
                progressBar.visibility = View.VISIBLE
                retryButton.visibility = View.GONE
            }
            is DataState.Success -> {
                progressBar.visibility = View.GONE
                offersAdapter.setList(state.data)
            }
            is DataState.Error -> {
                progressBar.visibility = View.GONE
                retryButton.visibility = View.VISIBLE
            }
        }
    }
}