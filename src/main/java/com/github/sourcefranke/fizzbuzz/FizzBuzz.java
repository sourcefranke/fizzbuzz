package com.github.sourcefranke.fizzbuzz;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Implementation of the FizzBuzz kata
 * 
 * @author sourcefranke
 */
public class FizzBuzz implements Function<Integer, String> {

	/**
	 * Setup method that initializes the FizzBuzz object with
	 * the well known default configuration of:
	 * 3 => "Fizz"
	 * 5 => "Buzz"
	 * 
	 * @return {@link FizzBuzz} object with default values
	 */
	public static FizzBuzz defaultSetup() {
		return new FizzBuzz().add(3, "Fizz").add(5, "Buzz");
	}
	
	private Map<Integer, String> replacementsMap;
	private PrintStream printer;
	
	public FizzBuzz() {
		this.printer = System.out;
		this.replacementsMap = new HashMap<>();
	}
	
	/**
	 * @param printer {@link PrintStream} that will be used as output stream
	 */
	public void setPrinter(PrintStream printer) {
		this.printer = printer;
	}

	/**
	 * Adds a new pair of modulos and the related text replacements
	 * 
	 * @param modulo number and its multiples to be replaced
	 * @param string text that will be shown instead of the given number and its multiples
	 * @return {@link FizzBuzz} object with modified set of numbers to be replaced together with its multiples
	 */
	public FizzBuzz add(Integer modulo, String string) {
		replacementsMap.put(modulo, string);
		return this;
	}

	/**
	 * Removes an existing pair of modulos and the related text replacements
	 * 
	 * @param modulo number and its multiples to be replaced
	 * @return {@link FizzBuzz} object with modified set of numbers to be replaced together with its multiples
	 */
	public FizzBuzz remove(Integer modulo) {
		replacementsMap.remove(modulo);
		return this;
	}

	/**
	 * Replaces any given positive number by its string representation, either the number itself or a specified text.
	 * 
	 * @param number a number to be replaced by a predefined text
	 * @return either the replacement text defined for the given number before or the number itself as a string
	 */
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
	
	/**
	 * Returns a {@link List} of "fizzbuzzed" numbers
	 * 
	 * @param max maximum number, to that the list should be filled
	 * @return list of fizzbuzzed numbers
	 */
	public List<String> toList(Integer max) {
		return toStream(max).collect(Collectors.toList());
	}
	
	/**
	 * Returns a {@link Stream} of "fizzbuzzed" numbers
	 * 
	 * @param max maximum number, to that the stream should be filled
	 * @return stream of fizzbuzzed numbers
	 */
	public Stream<String> toStream(Integer max) {
		return Stream
				.iterate(1, x -> ++x)
				.limit(max)
				.map(this);
	}
	
	/**
	 * Prints out all the "fizzbuzzed" numbers iterated from 1 to max using a {@link PrintStream} as output stream
	 * 
	 * @param max maximum number of iteration
	 */
	public void print(Integer max) {
		toStream(max).forEach(x -> printer.println(x));
	}
	
	/**
	 * main method
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("Please enter an integer (0 quits the program): ");
			
			int input = scanner.nextInt();
			
			if(input == 0) {
				break;
			}
			
			FizzBuzz.defaultSetup().print(input);
			System.out.println();
		}
		scanner.close();
	}
}
