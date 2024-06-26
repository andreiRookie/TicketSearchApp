package com.andreirookie.feat_hotels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class HotelsFragment : Fragment() {

    private lateinit var screenTitle: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(com.andreirookie.uikit.R.layout.stub_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        screenTitle = view.findViewById(com.andreirookie.uikit.R.id.screen_title)
        screenTitle.text = getString(com.andreirookie.uikit.R.string.hotels)
    }
}