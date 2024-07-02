package com.andreirookie.base_decimal_formatter

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

object DecimalFormatProvider {

    fun provideDecimalFormat(): DecimalFormat {
        val decimalFormatter = DecimalFormat("###,###")
        val formatSymbols = DecimalFormatSymbols()

        formatSymbols.groupingSeparator = ' '
        decimalFormatter.decimalFormatSymbols = formatSymbols

        return decimalFormatter
    }
}