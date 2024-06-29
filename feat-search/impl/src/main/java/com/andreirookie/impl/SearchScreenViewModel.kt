package com.andreirookie.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.andreirookie.impl.reposirory.OffersRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class SearchScreenViewModel @Inject constructor(
    private val repository: OffersRepository
) : ViewModel() {

    private val _offersFlow = MutableStateFlow<OffersState>(OffersState.Init)
    val offersStateFlow: StateFlow<OffersState> get() = _offersFlow

    init {
        getOffers()
    }

    private fun getOffers() {
        viewModelScope.launch {
            _offersFlow.update { OffersState.Loading }
            try {
                repository.getOffers().collect { list ->
                    _offersFlow.update {
                        OffersState.Data(list)
                    }
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _offersFlow.update {
                    OffersState.Error(e)
                }
            }
        }
    }


    class Factory @Inject constructor(
        private val repository: OffersRepository
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return when (modelClass) {
                SearchScreenViewModel::class.java -> {
                    SearchScreenViewModel(repository) as T
                }

                else -> {
                    error("Unknown $modelClass")
                }
            }
        }
    }
}