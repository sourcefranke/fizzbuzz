package com.github.sourcefranke.fizzbuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

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
		assertEquals(result, new FizzBuzz().add(2, "Foo").add(6, "Bar").apply(input));
	}
	
	@Test
	public void getList() {
		FizzBuzz fizzBuzz = Mockito.spy(FizzBuzz.class);
		
		when(fizzBuzz.apply(any(Integer.class))).thenReturn("number");
		when(fizzBuzz.apply(8)).thenReturn("ok");
		
		List<String> result = fizzBuzz.toList(10);

		assertEquals(10, result.size());
		
		assertEquals("number", result.get(0));
		assertEquals("number", result.get(1));
		assertEquals("number", result.get(2));
		assertEquals("number", result.get(3));
		assertEquals("number", result.get(4));
		assertEquals("number", result.get(5));
		assertEquals("number", result.get(6));
		assertEquals("ok", result.get(7));
		assertEquals("number", result.get(8));
		assertEquals("number", result.get(9));
	}
}
