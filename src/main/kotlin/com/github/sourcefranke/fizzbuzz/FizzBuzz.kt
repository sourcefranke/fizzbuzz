package com.github.sourcefranke.fizzbuzz

fun fizzBuzzNumber(wordsMap: Map<Int, String>, number: Int) =
        wordsMap.keys
                .filter { modulo -> number % modulo == 0 }
                .map { modulo -> wordsMap[modulo] }
                .filter { it!!.isNotEmpty() }
                .joinToString ( separator = "" )
                .ifEmpty { number.toString() }


fun fizzBuzzList(wordsMap: Map<Int, String>, numberList: List<Int>) =
        numberList.map { number -> fizzBuzzNumber(wordsMap, number) }