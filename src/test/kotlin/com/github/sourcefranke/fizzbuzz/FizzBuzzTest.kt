package com.github.sourcefranke.fizzbuzz

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class FizzBuzzTest {

    @Test
    fun testFizzBuzzNumber() {
        val wordsMap = mapOf(3 to "Fizz", 5 to "Buzz")

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
            (input, result) -> assertThat(fizzBuzzNumber(wordsMap, input)).isEqualTo(result)
        }
    }

    @Test
    fun testFizzBuzzList() {
        val inputList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
        val wordsMap = mapOf(3 to "Fizz", 5 to "Buzz")

        assertThat(fizzBuzzList(wordsMap, inputList))
                .hasSize(16)
                .containsExactly("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz", "16")
    }
}