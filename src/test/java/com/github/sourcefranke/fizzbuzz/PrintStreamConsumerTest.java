package com.github.sourcefranke.fizzbuzz;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class PrintStreamConsumerTest {
	
	@Mock
	private PrintStream printStream;
	
	private PrintStreamConsumer consumer;
	
	@BeforeEach
	public void setUp() {
		consumer = new PrintStreamConsumer(printStream);
	}
	
	@ParameterizedTest(name = "printed \"{0}\"")
	@CsvSource({"test", "yeah"})
	public void accept(String string) {
		consumer.accept(string);
		
		verify(printStream).println(string);
		verifyNoMoreInteractions(printStream);
	}
}
