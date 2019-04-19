package com.github.sourcefranke.fizzbuzz;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Implementation of the FizzBuzz kata
 * 
 * @author sourcefranke
 */
public class FizzBuzz {
	
	private Map<Integer, String> replacementsMap;
	
	public FizzBuzz() {
		this.replacementsMap = new HashMap<>();
	}

	/**
	 * Adds a new pair of modulos and the related text replacements
	 * 
	 * @param modulo number and its multiples to be replaced
	 * @param string text that will be shown instead of the given number and its multiples
	 * @return {@link FizzBuzz} object with modified set of numbers to be replaced together with its multiples
	 */
	public FizzBuzz add(Integer modulo, String string) {
		replacementsMap.put(modulo, string);
		return this;
	}

	/**
	 * Replaces any given positive number by its string representation, either the number itself or a specified text.
	 * 
	 * @param number a number to be replaced by a predefined text
	 * @return either the replacement text defined for the given number before or the number itself as a string
	 */
	public String replaceNumber(Integer number) {
		return Optional.of(
				replacementsMap.keySet().stream()
				.filter(modulo -> number % modulo == 0)
				.map(replacementsMap::get)
				.collect(Collectors.joining())
			)
			.filter(string -> !string.isEmpty())
			.orElseGet(number::toString);
	}
	
	/**
	 * Returns a {@link Stream} of "fizzbuzzed" numbers
	 * 
	 * @param max maximum number, to that the stream should be filled
	 * @return stream of fizzbuzzed numbers
	 */
	public Stream<String> toStream(Integer max) {
		return Stream
				.iterate(1, x -> ++x)
				.limit(max)
				.map(this::replaceNumber);
	}
	
	public static void main(String[] args) {
		new FizzBuzz()
			.add(3, "Fizz")
			.add(5, "Buzz")
			.add(4, "Foo")
			.add(7, "Bar")
			.toStream(100)
			.forEach(System.out::println);
	}
}
