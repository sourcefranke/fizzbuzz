package com.github.sourcefranke.fizzbuzz

import assertk.all
import assertk.assertThat
import assertk.assertions.*
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class FizzBuzzTest : ShouldSpec({
    context("convertFizzBuzzNumber") {
        forAll(
            row(1, "1"),
            row(2, "2"),
            row(3, "Fizz"),
            row(4, "4"),
            row(5, "Buzz"),
            row(6, "Fizz"),
            row(7, "7"),
            row(8, "8"),
            row(9, "Fizz"),
            row(10, "Buzz"),
            row(11, "11"),
            row(12, "Fizz"),
            row(13, "13"),
            row(14, "14"),
            row(15, "FizzBuzz"),
            row(16, "16")
        ) {input, result ->
            convertFizzBuzzNumber(input) shouldBe result
        }
    }

    context("convertFizzBuzzList") {
        val inputList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)

        assertThat(convertFizzBuzzList(inputList)).all {
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