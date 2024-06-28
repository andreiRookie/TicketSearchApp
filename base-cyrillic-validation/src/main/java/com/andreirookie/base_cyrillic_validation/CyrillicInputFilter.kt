package com.andreirookie.base_cyrillic_validation

import android.text.InputFilter
import android.text.SpannableString
import android.text.Spanned
import android.text.TextUtils
import java.lang.StringBuilder

class CyrillicInputFilter : InputFilter {
    override fun filter(
        source: CharSequence?,
        start: Int,
        end: Int,
        dest: Spanned?,
        dstart: Int,
        dend: Int
    ): CharSequence {
        val sb = StringBuilder(end - start)
        source?.forEach { char ->
            if (CyrillicInputValidator.isCyrillicChar(char)) {
                sb.append(char)
            }
        }

        if (source is Spanned) {
            val spannableString = SpannableString(sb)
            TextUtils.copySpansFrom(source, start, sb.length, null, spannableString, 0)
            return spannableString
        } else {
            return sb
        }
    }
}