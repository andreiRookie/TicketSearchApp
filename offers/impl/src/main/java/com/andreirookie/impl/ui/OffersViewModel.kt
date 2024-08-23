package com.andreirookie.impl.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.andreirookie.api.ui.DataState
import com.andreirookie.impl.domain.dto.OfferItemModel
import com.andreirookie.impl.domain.usecase.GetOffersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class OffersViewModel @Inject constructor(
    private val getOffersUseCase: GetOffersUseCase
) : ViewModel() {

    private val _offersFlow = MutableStateFlow<DataState<List<OfferItemModel>>>(DataState.Loading())
    val offersFlow: StateFlow<DataState<List<OfferItemModel>>> get() = _offersFlow.asStateFlow()

    init {
        getOffers()
    }

    private fun getOffers() {
        viewModelScope.launch {
            _offersFlow.value = DataState.Success(getOffersUseCase.invoke())
        }
    }

    class Factory @Inject constructor(
        private val getOffersUseCase: GetOffersUseCase
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return when (modelClass) {
                OffersViewModel::class.java -> {
                    OffersViewModel(getOffersUseCase) as T
                }

                else -> {
                    error("Unknown $modelClass")
                }
            }
        }
    }
}