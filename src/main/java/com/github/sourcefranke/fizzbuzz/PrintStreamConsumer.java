package com.github.sourcefranke.fizzbuzz;

import java.io.PrintStream;
import java.util.function.Consumer;

public class PrintStreamConsumer implements Consumer<String> {
	
	private PrintStream printStream;
	
	public PrintStreamConsumer() {
		this(System.out);
	}
	
	public PrintStreamConsumer(PrintStream printStream) {
		this.printStream = printStream;
	}

	@Override
	public void accept(String string) {
		printStream.println(string);
	}
}
