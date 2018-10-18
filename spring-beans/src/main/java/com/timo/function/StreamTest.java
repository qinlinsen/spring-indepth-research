package com.timo.function;

import java.util.ArrayList;

/**
 * @author Abraham Qin
 * @since 2018/10/18
 */
public class StreamTest {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<10;i++){
			if(i%2!=0){
				continue;
			}
			list.add(i);
		}

		list.stream().filter((i)->i>6).forEach(System.out::println);
	}
}
