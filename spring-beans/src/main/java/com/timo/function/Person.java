package com.timo.function;

/**
 * @author Abraham Qin
 * @since 2018/10/18
 */
public class Person {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				'}';
	}
}
