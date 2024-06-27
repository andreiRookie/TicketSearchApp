package com.andreirookie.impl

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.andreirookie.impl.di.SearchFragmentComponent

class SearchFragment : Fragment() {

    private lateinit var fromEdittext: EditText
    private lateinit var toEdittext: EditText

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

        fromEdittext.hint = getString(R.string.search_screen_from_edittext_hint)
        toEdittext.hint = getString(R.string.search_screen_to_edittext_hint)
    }
}