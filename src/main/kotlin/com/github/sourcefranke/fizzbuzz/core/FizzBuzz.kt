package com.github.sourcefranke.fizzbuzz.core

import org.apache.logging.log4j.LogManager
import java.util.*
import java.util.stream.Collectors
import java.util.stream.Stream

/**
 * Implementation of the FizzBuzz kata
 *
 * @author sourcefranke
 */
class FizzBuzz {

    private val replacementsMap: MutableMap<Int, String>

    /**
     * Adds a new pair of modulo and its related text replacements
     *
     * @param modulo number and its multiples to be replaced
     * @param string text that will be shown instead of the given number and its multiples
     * @return [FizzBuzz] object with modified set of numbers to be replaced together with its multiples
     */
    fun add(modulo: Int, string: String): FizzBuzz {
        replacementsMap[modulo] = string
        LOGGER.info("Added modulo {} with string replacement '{}'", modulo, string)
        return this
    }

    /**
     * Removes an existing pair of modulo and its related text replacements
     *
     * @param modulo number and its multiples to be replaced
     * @return [FizzBuzz] object with modified set of numbers to be replaced together with its multiples
     */
    fun remove(modulo: Int): FizzBuzz {
        replacementsMap.remove(modulo)
        LOGGER.info("Removed modulo {}", modulo)
        return this
    }

    /**
     * Replaces any given positive number by its string representation, either the number itself or a specified text.
     *
     * @param number a number to be replaced by a predefined text
     * @return either the replacement text defined for the given number before or the number itself as a string
     */
    fun replaceNumber(number: Int): String {
        val result = Optional.of(
                replacementsMap.keys.stream()
                        .filter { modulo: Int -> number % modulo == 0 }
                        .map { key: Int -> replacementsMap[key] }
                        .collect(Collectors.joining())
        )
                .filter { string: String -> !string.isEmpty() }
                .orElseGet { number.toString() }
        LOGGER.debug("Replaced {} with '{}'", number, result)
        return result
    }

    /**
     * Returns a [Stream] of "fizzbuzzed" numbers
     *
     * @param max maximum number, to that the stream should be filled
     * @return stream of fizzbuzzed numbers
     */
    fun stream(max: Int): Stream<String> {
        LOGGER.debug("Stream to {}", max)
        return Stream
                .iterate(1, { x: Int -> x + 1 })
                .limit(max.toLong())
                .map { number: Int -> replaceNumber(number) }
    }

    /**
     * Returns a [Stream] of "fizzbuzzed" numbers
     *
     * @param min minimum number, from that the stream should be filled (included)
     * @param max maximum number, to that the stream should be filled (included)
     * @return stream of fizzbuzzed numbers
     */
    fun stream(min: Int, max: Int): Stream<String> {
        LOGGER.debug("Stream from {} to {}", min, max)
        return Stream
                .iterate(min, { x: Int -> x + 1 })
                .limit(max - min + 1.toLong())
                .map { number: Int -> replaceNumber(number) }
    }

    companion object {
        private val LOGGER = LogManager.getLogger()

        @JvmStatic
        fun main(args: Array<String>) {
            FizzBuzz()
                    .add(3, "Fizz")
                    .add(5, "Buzz")
                    .stream(100)
                    .collect(Collectors.toList())
        }
    }

    init {
        replacementsMap = HashMap()
    }
}