package com.github.sourcefranke.fizzbuzz

typealias Converter = (Int) -> String
typealias ConverterMap = Map<Int, Converter>

/**
 * Converts a number into its string version
 * @param number integer to be converted
 * @param mapping moduli mapped to related converters
 * @param default behavior to be executed, if no modulo suited
 * @return string version of given number
 */
fun fizzBuzz (
        number: Int,
        mapping: ConverterMap = mapOf(3 to { "Fizz" }, 5 to { "Buzz" }),
        default: Converter = { x -> x.toString() }
) =
        mapping.keys.asSequence()
                .filter { number % it == 0 }
                .map { mapping[it] }
                .map { it!!.invoke(number) }
                .joinToString ( separator = "" )
                .ifEmpty { default.invoke(number) }
