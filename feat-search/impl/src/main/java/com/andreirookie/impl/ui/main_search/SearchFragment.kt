package com.andreirookie.impl.ui.main_search

import android.content.Context
import android.os.Bundle
import android.text.InputFilter
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.andreirookie.api.OffersProvider
import com.andreirookie.api.di.AppWithProvidersFacade
import com.andreirookie.base_cyrillic_validation.CyrillicInputFilter
import com.andreirookie.impl.R
import com.andreirookie.impl.di.SearchFragmentComponent
import com.andreirookie.impl.ui.bottom.SearchBottomDialogFragment
import javax.inject.Inject

class SearchFragment : Fragment() {

    private lateinit var fromWhereEditText: EditText
    private lateinit var whereEditText: EditText

    private var bottomSheetDialogFragment: SearchBottomDialogFragment? = null

    @Inject
    lateinit var vmFactory: SearchScreenViewModel.Factory
    private val viewModel: SearchScreenViewModel by viewModels { vmFactory }

    @Inject
    lateinit var offersProvider: OffersProvider

    override fun onAttach(context: Context) {
        super.onAttach(context)

        SearchFragmentComponent
            .create(
                (requireActivity().application as AppWithProvidersFacade).provideFacade())
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

        fromWhereEditText = view.findViewById(com.andreirookie.uikit.R.id.from_where_edittext)
        whereEditText = view.findViewById(com.andreirookie.uikit.R.id.where_edittext)
//        progressBar = view.findViewById(R.id.progress_bar)

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

        childFragmentManager.findFragmentByTag("offers_block") ?: let {
            childFragmentManager.beginTransaction()
                .add(R.id.offers_block, offersProvider.getOffersFragment(), "offers_block")
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bottomSheetDialogFragment = null
    }

}