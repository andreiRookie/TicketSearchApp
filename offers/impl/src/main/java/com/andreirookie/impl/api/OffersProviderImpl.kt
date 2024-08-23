package com.andreirookie.impl.api

import androidx.fragment.app.Fragment
import com.andreirookie.api.OffersProvider
import com.andreirookie.impl.ui.OffersFragment
import javax.inject.Inject

internal class OffersProviderImpl @Inject constructor() : OffersProvider {
    override fun getOffersFragment(): Fragment {
        return OffersFragment()
    }
}