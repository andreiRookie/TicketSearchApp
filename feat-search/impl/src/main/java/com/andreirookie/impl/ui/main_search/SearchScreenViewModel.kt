package com.andreirookie.impl.ui.main_search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.andreirookie.impl.usecase.GetOffersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchScreenViewModel @Inject constructor(
    private val getOffersUseCase: GetOffersUseCase
) : ViewModel() {

    private val _offersFlow = MutableStateFlow<OffersState>(OffersState.Data(emptyList()))
    val offersStateFlow: StateFlow<OffersState> get() = _offersFlow.asStateFlow()

    init {
        getOffers()
    }

    private fun getOffers() {
        viewModelScope.launch {
            _offersFlow.value = OffersState.Loading
            _offersFlow.value = OffersState.Data(getOffersUseCase.invoke())
        }
    }

    class Factory @Inject constructor(
        private val getOffersUseCase: GetOffersUseCase
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return when (modelClass) {
                SearchScreenViewModel::class.java -> {
                    SearchScreenViewModel(getOffersUseCase) as T
                }

                else -> {
                    error("Unknown $modelClass")
                }
            }
        }
    }
}