package com.github.sourcefranke.fizzbuzz.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Implementation of the FizzBuzz kata
 * 
 * @author sourcefranke
 */
public class FizzBuzz {
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	private Map<Integer, String> replacementsMap;
	
	public FizzBuzz() {
		this.replacementsMap = new HashMap<>();
	}

	/**
	 * Adds a new pair of modulo and its related text replacements
	 * 
	 * @param modulo number and its multiples to be replaced
	 * @param string text that will be shown instead of the given number and its multiples
	 * @return {@link FizzBuzz} object with modified set of numbers to be replaced together with its multiples
	 */
	public FizzBuzz add(Integer modulo, String string) {
		replacementsMap.put(modulo, string);
		LOGGER.info("Added modulo {} with string replacement '{}'", modulo, string);
		return this;
	}

	/**
	 * Removes an existing pair of modulo and its related text replacements
	 * 
	 * @param modulo number and its multiples to be replaced
	 * @return {@link FizzBuzz} object with modified set of numbers to be replaced together with its multiples
	 */
	public FizzBuzz remove(Integer modulo) {
		replacementsMap.remove(modulo);
		LOGGER.info("Removed modulo {}", modulo);
		return this;
	}

	/**
	 * Replaces any given positive number by its string representation, either the number itself or a specified text.
	 * 
	 * @param number a number to be replaced by a predefined text
	 * @return either the replacement text defined for the given number before or the number itself as a string
	 */
	public String replaceNumber(Integer number) {
		String result =
				Optional.of(
					replacementsMap.keySet().stream()
					.filter(modulo -> number % modulo == 0)
					.map(replacementsMap::get)
					.collect(Collectors.joining())
				)
				.filter(string -> !string.isEmpty())
				.orElseGet(number::toString);
		
		LOGGER.debug("Replaced {} with '{}'", number, result);
		return result;
	}
	
	/**
	 * Returns a {@link Stream} of "fizzbuzzed" numbers
	 * 
	 * @param max maximum number, to that the stream should be filled
	 * @return stream of fizzbuzzed numbers
	 */
	public Stream<String> stream(Integer max) {
		LOGGER.debug("Stream to {}", max);
		return Stream
				.iterate(1, x -> x + 1)
				.limit(max)
				.map(this::replaceNumber);
	}
	
	/**
	 * Returns a {@link Stream} of "fizzbuzzed" numbers
	 * 
	 * @param min minimum number, from that the stream should be filled (included)
	 * @param max maximum number, to that the stream should be filled (included)
	 * @return stream of fizzbuzzed numbers
	 */
	public Stream<String> stream(Integer min, Integer max) {
		LOGGER.debug("Stream from {} to {}", min, max);
		return Stream
				.iterate(min, x -> x + 1)
				.limit(max - min + 1)
				.map(this::replaceNumber);
	}
	
	public static void main(String[] args) {
		new FizzBuzz()
			.add(3, "Fizz")
			.add(5, "Buzz")
			.stream(100)
			.collect(Collectors.toList());
	}
}
