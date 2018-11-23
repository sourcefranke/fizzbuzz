package com.github.sourcefranke.fizzbuzz;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FizzBuzzOperator {

	private FizzBuzz fizzBuzz;
	
	public FizzBuzzOperator(FizzBuzz fizzBuzz) {
		this.fizzBuzz = fizzBuzz;
	}
	
	public List<String> toList(Integer max) {
		return toStream(max)
				.collect(Collectors.toList());
	}

	public Stream<String> toStream(Integer max) {
		return Stream
				.iterate(1, x -> ++x)
				.limit(max)
				.map(fizzBuzz);
	}
	
	/**
	 * main method
	 */
	public static void main(String[] args) {
		new FizzBuzzOperator(FizzBuzz.defaultSetup())
			.toStream(60)
			.forEach(new PrintStreamConsumer());
	}
}
