package com.github.sourcefranke.fizzbuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class FizzBuzzOperatorTest {
	
	@Mock
	private FizzBuzz fizzBuzz;
	
	private FizzBuzzOperator operator;
	
	@BeforeEach
	public void setUp() {
		operator = new FizzBuzzOperator(fizzBuzz);
	}
	
	@Test
	public void getList() {
		when(fizzBuzz.apply(any(Integer.class))).thenReturn("number");
		when(fizzBuzz.apply(8)).thenReturn("ok");
		
		List<String> result = operator.toList(10);

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
