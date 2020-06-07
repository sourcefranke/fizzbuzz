package com.github.sourcefranke.fizzbuzz

fun fizzBuzzNumber (
        number: Int,
        wordsMap: Map<Int, (Int) -> String> = mapOf(3 to ::fizz, 5 to ::buzz),
        default: (Int) -> String = ::numberToString
) =
        wordsMap.keys
                .filter { modulo -> number % modulo == 0 }
                .map { modulo -> wordsMap[modulo] }
                .map { u -> u?.invoke(number) }
                .filter { it!!.isNotEmpty() }
                .joinToString ( separator = "" )
                .ifEmpty { default(number) }

fun fizzBuzzList (
        numberList: List<Int>,
        wordsMap: Map<Int, (Int) -> String> = mapOf(3 to ::fizz, 5 to ::buzz),
        default: (Int) -> String = ::numberToString
) =
        numberList.map { number -> fizzBuzzNumber(number, wordsMap, default) }


// Helper functions for replacing numbers by text

fun numberToString (number: Int) = number.toString()
@Suppress("UNUSED_PARAMETER")
fun fizz (number: Int) = "Fizz"
@Suppress("UNUSED_PARAMETER")
fun buzz (number: Int) = "Buzz"

fun repeatNumber (number: Int): String {
    var result = ""
    repeat(number) { result += number }
    return result
}