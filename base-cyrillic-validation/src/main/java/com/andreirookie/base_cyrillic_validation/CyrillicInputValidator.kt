package com.andreirookie.base_cyrillic_validation

import java.util.regex.Pattern

object CyrillicInputValidator {

    private val cyrillicRegex = Pattern.compile("[а-яёА-ЯЁ\\s]+").toRegex()

    fun isCyrillicChar(char: Char?): Boolean {
        if (char == null) return false
        return cyrillicRegex.containsMatchIn(char.toString())
    }
}