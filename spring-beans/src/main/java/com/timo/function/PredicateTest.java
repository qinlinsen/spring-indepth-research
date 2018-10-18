package com.timo.function;

import java.awt.*;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author Abraham Qin
 * @since 2018/10/18
 */
public class PredicateTest {
	public static void main(String[] args) {
		Predicate<String> predicate = (s) -> s.length() > 0;
		boolean foo = predicate.test("foo");
		System.out.println("foo="+foo);

		boolean foo1 = predicate.negate().test("foo");
		System.out.println("foo1 "+foo1);

		Predicate isNull = Objects::isNull;

		Supplier<Person> personSupplier=Person::new;
		Person person = personSupplier.get();
		System.out.println(person);

		Person person1 = new Person();
		person1.setName("账务");
		//consume:
		Consumer<Person> greeter=(p)-> System.out.println("hello"+" "+p.getName());
		greeter.accept(person1);


	}
}
