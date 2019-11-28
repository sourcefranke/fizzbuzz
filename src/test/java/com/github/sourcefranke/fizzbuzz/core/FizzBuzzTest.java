package com.github.sourcefranke.fizzbuzz.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.github.sourcefranke.fizzbuzz.core.FizzBuzz;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class FizzBuzzTest {
	
	@Spy
	private FizzBuzz fizzBuzz;

	@ParameterizedTest(name = "{0} => \"{1}\"")
	@MethodSource
	public void testReplaceNumber(Integer input, String result) {
		fizzBuzz.add(3, "Fizz").add(5, "Buzz");
		assertThat(fizzBuzz.replaceNumber(input)).isEqualTo(result);
	}
	
	private static Stream<Arguments> testReplaceNumber() {
	    return Stream.of(
	    		Arguments.of(1, "1"),
	    		Arguments.of(2, "2"),
	    		Arguments.of(3, "Fizz"),
	    		Arguments.of(4, "4"),
	    		Arguments.of(5, "Buzz"),
	    		Arguments.of(6, "Fizz"),
	    		Arguments.of(7, "7"),
	    		Arguments.of(8, "8"),
	    		Arguments.of(9, "Fizz"),
	    		Arguments.of(10, "Buzz"),
	    		Arguments.of(11, "11"),
	    		Arguments.of(12, "Fizz"),
	    		Arguments.of(13, "13"),
	    		Arguments.of(14, "14"),
	    		Arguments.of(15, "FizzBuzz"),
	    		Arguments.of(16, "16")
	    	);
	}
	
	@Test
	public void testToStream() {
		when(fizzBuzz.replaceNumber(any(Integer.class))).thenReturn("number");
		when(fizzBuzz.replaceNumber(7)).thenReturn("ok");
		
		List<String> result = fizzBuzz.toStream(10).collect(Collectors.toList());

		assertThat(result)
			.hasSize(10)
			.containsExactly(
				"number",
				"number",
				"number",
				"number",
				"number",
				"number",
				"ok",
				"number",
				"number",
				"number"
			);
	}
}
