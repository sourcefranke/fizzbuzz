package com.github.sourcefranke.functionutils;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Utility class for offering some kind of if/else construct for functions.
 * 
 * @author sourcefranke
 *
 * @param <T> Input type
 * @param <R> return type within Optional 
 */
public class ConditionalFunction <T, R> implements Function<T, Optional<R>> {
	
	private Predicate<T> ifExpr;
	private Function<T, R> thenFunc, elseFunc;
	
	private ConditionalFunction(Predicate<T> ifExpr) {
		this.ifExpr = ifExpr;
	}

	/**
	 * Initializes the {@link ConditionalFunction} object
	 * 
	 * @param ifExpr {@link Predicate} representing the if condition
	 * @return object of {@link ConditionalFunction} with if conditon
	 */
	public static <T, R> ConditionalFunction<T, R> ifExpr(Predicate<T> ifExpr) {
		return new ConditionalFunction<T, R>(ifExpr);
	}
	
	/**
	 * Defines the then-block of the if construct
	 * 
	 * @param thenFunc {@link Function} to be called if condition is true
	 * @return object of {@link ConditionalFunction} with defined then-block
	 */
	public ConditionalFunction<T, R> thenFunc(Function<T, R> thenFunc) {
		this.thenFunc = thenFunc;
		return this;
	}

	/**
	 * Defines the else-block of the if construct
	 * 
	 * @param thenFunc {@link Function} to be called if condition is false
	 * @return object of {@link ConditionalFunction} with defined else-block
	 */
	public ConditionalFunction<T, R> elseFunc(Function<T, R> elseFunc) {
		this.elseFunc = elseFunc;
		return this;
	}

	@Override
	public Optional<R> apply(T t) {
		Optional<R> opt = Optional.of(t).filter(ifExpr).map(thenFunc);
		if(elseFunc != null) {
			return Optional.of(opt.orElse(Optional.of(t).map(elseFunc).get()));
		}
		else {
			return opt;
		}
	}
}
