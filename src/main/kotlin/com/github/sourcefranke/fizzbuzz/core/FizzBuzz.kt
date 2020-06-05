package com.github.sourcefranke.fizzbuzz.core

/**
 * Implementation of the FizzBuzz kata
 *
 * @author sourcefranke
 */
class FizzBuzz {

    private val replacementsMap: MutableMap<Int, String>

    init {
        replacementsMap = HashMap()
    }

    /**
     * Adds a new pair of modulo and its related text replacements
     *
     * @param modulo number and its multiples to be replaced
     * @param replacement text that will be shown instead of the given number and its multiples
     * @return [FizzBuzz] object with modified set of numbers to be replaced together with its multiples
     */
    fun add(modulo: Int, replacement: String): FizzBuzz {
        replacementsMap[modulo] = replacement
        return this
    }

    /**
     * Replaces any given positive number by its string representation, either the number itself or a specified text.
     *
     * @param number a number to be replaced by a predefined text
     * @return either the replacement text defined for the given number or the number itself (as a string)
     */
    fun replaceNumber(number: Int) =
            replacementsMap.keys
                .filter { modulo -> number % modulo == 0 }
                .map { key: Int -> replacementsMap[key] }
                .filter { it!!.isNotEmpty() }
                .joinToString ( separator = "" )
                .ifEmpty { number.toString() }
}
