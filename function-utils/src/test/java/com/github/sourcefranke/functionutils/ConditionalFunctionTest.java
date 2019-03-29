package com.github.sourcefranke.functionutils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ConditionalFunctionTest {
	
	@ParameterizedTest
	@CsvSource ({
		"1, 1",
		"2, 2",
		"3, 3!",
		"4, 4",
		"5, 5",
		"6, 6!"
	})
	public void leapYear(Integer input, String expected) {
		Optional<String> result = Optional.of(input)
		.map(
			ConditionalFunction.<Integer, String>
				ifExpr(x -> x % 3 == 0)
				.thenFunc(x -> x + "!")
				.elseFunc(x -> x.toString())
		).get();
		
		assertEquals(expected, result.get());
	}

	@Test
	public void primeNumber_withElse() {
		Stream.of(1, 2, 3, 4, 5, 6)
		.map(
			ConditionalFunction.<Integer, String>
				ifExpr(x -> BigInteger.valueOf(x).isProbablePrime(1))
				.thenFunc(x -> "Prime: " + x)
				.elseFunc(x -> "No Prime")
				.andThen(Optional::get)
		)
		.forEach(System.out::println);
		
		// no exception or error thrown!!!
		Assertions.assertTrue(true);
	}

	@Test
	public void primeNumber_withoutElse() {
		Stream.of(1, 2, 3, 4, 5, 6)
		.map(
			ConditionalFunction.<Integer, String>
				ifExpr(x -> BigInteger.valueOf(x).isProbablePrime(1))
				.thenFunc(x -> "Prime: " + x)
		)
		.filter(Optional::isPresent)
		.forEach(System.out::println);
		
		// no exception or error thrown!!!
		Assertions.assertTrue(true);
	}
}
