package com.github.sourcefranke.fizzbuzz.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Spy
import org.mockito.junit.jupiter.MockitoExtension
import java.util.stream.Collectors
import java.util.stream.Stream

class FizzBuzzTest {

    val fizzBuzz: FizzBuzz = FizzBuzz()

    @Test
    fun testReplaceNumber() {
        fizzBuzz.add(3, "Fizz").add(5, "Buzz")

        assertThat(fizzBuzz.replaceNumber(1)).isEqualTo("1")
        assertThat(fizzBuzz.replaceNumber(2)).isEqualTo("2")
        assertThat(fizzBuzz.replaceNumber(3)).isEqualTo("Fizz")
        assertThat(fizzBuzz.replaceNumber(4)).isEqualTo("4")
        assertThat(fizzBuzz.replaceNumber(5)).isEqualTo("Buzz")
        assertThat(fizzBuzz.replaceNumber(6)).isEqualTo("Fizz")
        assertThat(fizzBuzz.replaceNumber(7)).isEqualTo("7")
        assertThat(fizzBuzz.replaceNumber(8)).isEqualTo("8")
        assertThat(fizzBuzz.replaceNumber(9)).isEqualTo("Fizz")
        assertThat(fizzBuzz.replaceNumber(10)).isEqualTo("Buzz")
        assertThat(fizzBuzz.replaceNumber(11)).isEqualTo("11")
        assertThat(fizzBuzz.replaceNumber(12)).isEqualTo("Fizz")
        assertThat(fizzBuzz.replaceNumber(13)).isEqualTo("13")
        assertThat(fizzBuzz.replaceNumber(14)).isEqualTo("14")
        assertThat(fizzBuzz.replaceNumber(15)).isEqualTo("FizzBuzz")
        assertThat(fizzBuzz.replaceNumber(16)).isEqualTo("16")
    }
}