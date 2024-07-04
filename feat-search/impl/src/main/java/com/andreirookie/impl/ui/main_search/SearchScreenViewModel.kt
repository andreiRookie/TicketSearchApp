package com.andreirookie.impl.ui.main_search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.andreirookie.impl.reposirory.OffersRepository
import com.andreirookie.impl.reposirory.OffersStubRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchScreenViewModel @Inject constructor(
    private val repository: OffersRepository,
    private val stubRepository: OffersStubRepository
) : ViewModel() {

    private val _offersFlow = MutableStateFlow<OffersState>(OffersState.Data(emptyList()))
    val offersStateFlow: StateFlow<OffersState> get() = _offersFlow.asStateFlow()

    init {
        getOffers()
    }

    private fun getOffers() {
        viewModelScope.launch {

            _offersFlow.value = OffersState.Loading

            try {
                _offersFlow.value = OffersState.Data(repository.getOffers())
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _offersFlow.value = OffersState.Data(stubRepository.getOffers())
            }
        }
    }


    class Factory @Inject constructor(
        private val repository: OffersRepository,
        private val stubRepository: OffersStubRepository
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return when (modelClass) {
                SearchScreenViewModel::class.java -> {
                    SearchScreenViewModel(repository, stubRepository) as T
                }

                else -> {
                    error("Unknown $modelClass")
                }
            }
        }
    }
}