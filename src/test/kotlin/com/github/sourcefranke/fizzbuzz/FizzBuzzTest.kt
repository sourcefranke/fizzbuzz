package com.github.sourcefranke.fizzbuzz

import assertk.all
import assertk.assertThat
import assertk.assertions.*
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class FizzBuzzTest : ShouldSpec({
    context("fizzBuzz") {
        listOf(
                1 to "1",
                2 to "2",
                3 to "Fizz",
                4 to "4",
                5 to "Buzz",
                6 to "Fizz",
                7 to "7",
                8 to "8",
                9 to "Fizz",
                10 to "Buzz",
                11 to "11",
                12 to "Fizz",
                13 to "13",
                14 to "14",
                15 to "FizzBuzz",
                16 to "16"
        ).forEach {(input, result) ->
            fizzBuzz(input) shouldBe result
        }
    }

    context("fizzBuzzList") {
        val numbers =
                listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
                .map { fizzBuzz(it) }

        assertThat(numbers).all {
            hasSize(16)
            containsAll("1", "2", "4", "7", "8", "11", "13", "14", "16", "Fizz", "Buzz", "FizzBuzz")
            doesNotContain("3")
            doesNotContain("5")
            doesNotContain("6")
            doesNotContain("9")
            doesNotContain("10")
            doesNotContain("12")
            doesNotContain("15")
        }
    }
})
