package com.github.sourcefranke.fizzbuzz;

import static org.mockito.Mockito.*;

import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
	
	@Test
	public void accept_test() {
		consumer.accept("test");
		
		verify(printStream).println("test");
		verifyNoMoreInteractions(printStream);
	}
	
	@Test
	public void accept_yeah() {
		consumer.accept("yeah");
		
		verify(printStream).println("yeah");
		verifyNoMoreInteractions(printStream);
	}
}
