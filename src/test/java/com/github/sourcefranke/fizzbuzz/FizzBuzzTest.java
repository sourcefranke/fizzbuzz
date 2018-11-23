package com.github.sourcefranke.fizzbuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FizzBuzzTest {

	@ParameterizedTest(name = "{0} => \"{1}\"")
	@CsvSource({
		"1, '1'",
		"2, '2'",
		"3, 'Fizz'",
		"4, '4'",
		"5, 'Buzz'",
		"6, 'Fizz'",
		"7, '7'"
	})
	public void defaultSetup(Integer input, String result) {
		assertEquals(result, FizzBuzz.defaultSetup().apply(input));
	}

	@ParameterizedTest(name = "{0} => \"{1}\"")
	@CsvSource({
		"1, '1'",
		"2, 'Foo'",
		"3, '3'",
		"4, 'Foo'",
		"5, '5'",
		"6, 'FooBar'",
		"7, '7'"
	})
	public void emptySetup(Integer input, String result) {
		assertEquals(result, FizzBuzz.emptySetup()
								.add(2, "Foo")
								.add(6, "Bar")
								.apply(input));
	}
}
