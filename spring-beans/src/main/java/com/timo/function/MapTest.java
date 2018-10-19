package com.timo.function;

import java.util.HashMap;

/**
 * @author Abraham Qin
 * @since 2018/10/19
 */
public class MapTest {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.putIfAbsent("a","b");
		System.out.println(map.size());
		map.put("a","b");
		System.out.println(map.size());
		map.forEach((key,value)->{
			System.out.println(String.format("%s=%s",key,value));
		});
	}
}
