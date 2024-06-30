package com.andreirookie.impl.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

class EditTextWatcherFacade(
    private val editText: EditText
) {

    fun startListen(block: () -> Unit) {
        editText.addTextChangedListener(getTextWatcher(block))
    }

    private fun getTextWatcher(block: () -> Unit) = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) { block() }
    }
}