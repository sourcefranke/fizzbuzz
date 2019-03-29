package com.github.sourcefranke.fizzbuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.intThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

public class FizzBuzzTest {
	
	private FizzBuzz fizzBuzz;
	
	@BeforeEach
	public void setUp() {
		fizzBuzz = new FizzBuzz().add(3, "Fizz").add(5, "Buzz");
	}

	@ParameterizedTest(name = "{0} => \"{1}\"")
	@CsvSource({
		"1, '1'",
		"2, '2'",
		"3, 'Fizz'",
		"4, '4'",
		"5, 'Buzz'",
		"6, 'Fizz'",
		"7, '7'",
		"8, '8'",
		"9, 'Fizz'",
		"10, 'Buzz'",
		"11, '11'",
		"12, 'Fizz'",
		"13, '13'",
		"14, '14'",
		"15, 'FizzBuzz'",
		"16, '16'"
	})
	public void defaultSetup(Integer input, String result) {
		assertEquals(result, fizzBuzz.replaceNumber(input));
	}
	
	@Test
	public void toStream() {
		FizzBuzz fizzBuzz = Mockito.spy(FizzBuzz.class);
		
		when(fizzBuzz.replaceNumber(any(Integer.class))).thenReturn("number");
		when(fizzBuzz.replaceNumber(
			intThat(Matchers.isIn(Arrays.asList(3, 6, 9)))
		)).thenReturn("ok");
		
		List<String> result = fizzBuzz.toStream(10).collect(Collectors.toList());

		assertEquals(10, result.size());
		
		assertEquals("number", result.get(0));
		assertEquals("number", result.get(1));
		assertEquals("ok", result.get(2));
		assertEquals("number", result.get(3));
		assertEquals("number", result.get(4));
		assertEquals("ok", result.get(5));
		assertEquals("number", result.get(6));
		assertEquals("number", result.get(7));
		assertEquals("ok", result.get(8));
		assertEquals("number", result.get(9));
	}
}
