package com.github.sourcefranke.fizzbuzz;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FizzBuzz implements Function<Integer, String> {
	
	private Map<Integer, String> replacementsMap;
	
	private FizzBuzz() {
		this.replacementsMap = new HashMap<>();
	}

	public FizzBuzz add(Integer key, String string) {
		replacementsMap.put(key, string);
		return this;
	}

	public FizzBuzz remove(Integer key) {
		replacementsMap.remove(key);
		return this;
	}

	@Override
	public String apply(Integer number) {
		return Optional.of(
				replacementsMap.keySet().stream()
				.filter(key -> number % key == 0)
				.map(key -> replacementsMap.get(key))
				.collect(Collectors.joining())
			)
			.map(x -> !x.isEmpty() ? x : number.toString())
			.get();
	}

	public static FizzBuzz defaultSetup() {
		return new FizzBuzz()
				.add(3, "Fizz")
				.add(5, "Buzz");
	}

	public static FizzBuzz emptySetup() {
		return new FizzBuzz();
	}
}
