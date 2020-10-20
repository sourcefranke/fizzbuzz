package com.github.sourcefranke.fizzbuzz

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class FizzBuzzTest {

    @Test
    fun `Test convertFizzBuzzNumber` () {
        listOf(
                Pair(1, "1"),
                Pair(2, "2"),
                Pair(3, "Fizz"),
                Pair(4, "4"),
                Pair(5, "Buzz"),
                Pair(6, "Fizz"),
                Pair(7, "7"),
                Pair(8, "8"),
                Pair(9, "Fizz"),
                Pair(10, "Buzz"),
                Pair(11, "11"),
                Pair(12, "Fizz"),
                Pair(13, "13"),
                Pair(14, "14"),
                Pair(15, "FizzBuzz"),
                Pair(16, "16")
        )
        .forEach {
            (input, result) -> assertThat(convertFizzBuzzNumber(input)).isEqualTo(result)
        }
    }

    @Test
    fun `Test convertFizzBuzzList` () {
        val inputList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)

        assertThat(convertFizzBuzzList(inputList))
                .hasSize(16)
                .containsExactly("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz", "16")
    }

    @Test
    fun `Test repeatNumber` () {
        listOf(
                Pair(1, "1"),
                Pair(2, "22"),
                Pair(3, "333"),
                Pair(4, "4444"),
                Pair(5, "55555"),
                Pair(6, "666666"),
                Pair(7, "7777777"),
                Pair(8, "88888888"),
                Pair(9, "999999999"),
                Pair(10, "10101010101010101010")
        )
        .forEach {
            (input, result) -> assertThat(repeatNumber(input)).isEqualTo(result)
        }
    }

    @Test
    fun `Test convertFizzBuzzList with repeatNumber as DefaultFunc` () {
        val inputList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

        assertThat(convertFizzBuzzList(inputList, defaultFunction = ::repeatNumber))
                .containsExactly("1", "22", "Fizz", "4444", "Buzz", "Fizz", "7777777", "88888888", "Fizz")
    }

    @Test
    fun `Test convertFizzBuzzList with function 'repeatNumber' for modulo by 3` () {
        val inputList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val mapping = mapOf(3 to ::repeatNumber, 5 to ::buzzFunc)

        assertThat(convertFizzBuzzList(inputList, mapping))
                .containsExactly("1", "2", "333", "4", "Buzz", "666666", "7", "8", "999999999")
    }

    @Test
    fun `Test equalFunc` () {
        listOf(
                Triple(1, 1, true),
                Triple(11, 4, false),
                Triple(4, 11, false),
                Triple(11, 11, true),
                Triple(4, 4, true)
        )
        .forEach {
            (first, second, result) -> assertThat(equalFunc(first, second)).isEqualTo(result)
        }
    }

    @Test
    fun `Test convertFizzBuzzNumber with equalFunc for 7 and 8` () {
        val mapping = mapOf(7 to ::seven, 8 to ::eight)

        listOf(
                Pair(1, "1"),
                Pair(2, "2"),
                Pair(3, "3"),
                Pair(4, "4"),
                Pair(5, "5"),
                Pair(6, "6"),
                Pair(7, "Seven"),
                Pair(8, "Eight"),
                Pair(9, "9"),
                Pair(10, "10"),
                Pair(11, "11"),
                Pair(12, "12"),
                Pair(13, "13"),
                Pair(14, "14"),
                Pair(15, "15"),
                Pair(16, "16")
        )
        .forEach {
            (input, result) -> assertThat(convertFizzBuzzNumber(input, mapping, ::equalFunc)).isEqualTo(result)
        }
    }
}

fun equalFunc (number: Int, key: Int): Boolean = number == key

@Suppress("UNUSED_PARAMETER")
fun seven (number: Int): String = "Seven"
@Suppress("UNUSED_PARAMETER")
fun eight (number: Int): String = "Eight"

fun repeatNumber (number: Int): String {
    var result = ""
    repeat(number) { result += number }
    return result
}