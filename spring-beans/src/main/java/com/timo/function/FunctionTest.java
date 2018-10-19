package com.timo.function;

import java.util.function.Function;

/**
 * @author Abraham Qin
 * @since 2018/10/19
 */
public class FunctionTest {
	public static void main(String[] args) {
		Function<String, Integer> toInteger = Integer::valueOf;
		Function<String, String> backToString = toInteger.andThen(String::valueOf);
		String result = backToString.apply("123");
		System.out.println(result);
	}
}
