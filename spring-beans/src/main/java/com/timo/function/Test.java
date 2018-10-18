package com.timo.function;

/**
 * @author Abraham Qin
 * @since 2018/10/18
 */
public class Test {
	public static void main(String[] args) {
		Convert<String, String> start = Something::startWith;
		String result = start.convert("123");
		System.out.println(result);

		Something something = new Something();
		Convert<String, String> end = something::endWith;
		String abc = end.convert("abc");
		System.out.println(abc);

		Runnable runnable = Something::new;
		runnable.run();

		Convert<String,Something> convert=Something::new;
		convert.convert("Abraham Lincoln");
	}
}
