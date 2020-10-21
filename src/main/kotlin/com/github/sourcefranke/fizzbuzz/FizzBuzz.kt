package com.github.sourcefranke.fizzbuzz

val defaultMapping = mapOf(3 to "Fizz", 5 to "Buzz")

/**
 * Converts a number into its string representation
 * @param number integer to be converted
 * @param mapping moduli mapped to their string terms
 */
fun fizzBuzzNumber (
        number: Int,
        mapping: Map<Int, String> = defaultMapping
) =
        mapping.keys.asSequence()
                .filter { key -> number % key == 0 }
                .map { key -> mapping[key] }
                .joinToString ( separator = "" )
                .ifEmpty { number.toString() }

/**
 * Converts a list of numbers into their string representations
 * @param numbers list of integers to be converted
 * @param mapping moduli mapped to their string terms
 */
fun fizzBuzzList (
        numbers: List<Int>,
        mapping: Map<Int, String> = defaultMapping
) =
        numbers.map { number -> fizzBuzzNumber(number, mapping) }
