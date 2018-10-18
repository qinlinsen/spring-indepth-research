package com.timo.function;

import java.util.Optional;

/**
 * @author Abraham Qin
 * @since 2018/10/18
 */
public class OptionalTest {
	public static void main(String[] args) {
		Optional<String> ban = Optional.ofNullable(null);
	/*	String s = ban.get();
		System.out.println("s="+s);
*/
		boolean present = ban.isPresent();
		System.out.println(present);

		String other = ban.orElse("other");
		System.out.println(other);
	}
}
