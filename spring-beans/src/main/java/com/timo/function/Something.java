package com.timo.function;

import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @author Abraham Qin
 * @since 2018/10/18
 */
public class Something {
	/**
	 * constructor method:
	 */

	public Something() {
		System.out.println("something");
	}

	public Something(String something) {
		System.out.println(something);
	}

	/**
	 * static method:
	 * @param s a string
	 * @return
	 */
	public static  String startWith(String s){
		Objects.requireNonNull(s);

		if (StringUtils.hasText(s)) {
			return String.valueOf(s.charAt(0));
		}
		return "";
	}

	/**
	 * object method:
	 */
	public void printHelloMessage(){
		System.out.println("hello");
	}

	public String endWith(String s){
		Objects.requireNonNull(s);
		if(StringUtils.hasText(s)){
			return String.valueOf(s.charAt(s.length()-1));
		}
		return "";
	}
}
