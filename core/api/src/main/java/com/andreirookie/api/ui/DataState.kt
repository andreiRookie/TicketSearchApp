package com.andreirookie.api.ui


sealed interface DataState<T> {

    data class Success<T>(val data: T) : DataState<T>

    data class Error<T>(val e: Exception? = null) : DataState<T>

    class Loading<T> : DataState<T>
}