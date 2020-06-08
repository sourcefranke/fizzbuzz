package com.github.sourcefranke.fizzbuzz

fun convertFizzBuzzNumber (
        number: Int,
        mapping: Map<Int, (Int) -> String> = mapOf(3 to ::fizzFunc, 5 to ::buzzFunc),
        filterFunction: (Int, Int) -> Boolean = ::moduloFunc,
        defaultFunction: (Int) -> String = ::numberToStringFunc
) =
        mapping.keys.asSequence()
                .filter { key -> filterFunction(number, key) }
                .map { key -> mapping[key] }
                .map { func -> func?.invoke(number) }
                .filter { it!!.isNotEmpty() }
                .joinToString ( separator = "" )
                .ifEmpty { defaultFunction(number) }

fun convertFizzBuzzList (
        numberList: List<Int>,
        mapping: Map<Int, (Int) -> String> = mapOf(3 to ::fizzFunc, 5 to ::buzzFunc),
        filterFunction: (Int, Int) -> Boolean = ::moduloFunc,
        defaultFunction: (Int) -> String = ::numberToStringFunc
) =
        numberList.map { number -> convertFizzBuzzNumber(number, mapping, filterFunction, defaultFunction) }


// Helper functions for replacing numbers by text

fun moduloFunc (number: Int, modulo: Int): Boolean = number % modulo == 0
fun equalFunc (number: Int, key: Int): Boolean = number == key

fun numberToStringFunc (number: Int): String = number.toString()
@Suppress("UNUSED_PARAMETER")
fun fizzFunc (number: Int): String = "Fizz"
@Suppress("UNUSED_PARAMETER")
fun buzzFunc (number: Int): String = "Buzz"

fun repeatNumber (number: Int): String {
    var result = ""
    repeat(number) { result += number }
    return result
}