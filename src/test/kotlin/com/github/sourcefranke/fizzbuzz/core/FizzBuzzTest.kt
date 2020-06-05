package com.github.sourcefranke.fizzbuzz.core

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class FizzBuzzTest {

    private lateinit var fizzBuzz: FizzBuzz

    @BeforeEach
    fun setUp() {
        fizzBuzz = FizzBuzz()
    }

    @Test
    fun testReplaceNumber() {
        fizzBuzz.add(3, "Fizz")
                .add(5, "Buzz")

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
            (input, result) -> assertThat(fizzBuzz.replaceNumber(input)).isEqualTo(result)
        }
    }
}