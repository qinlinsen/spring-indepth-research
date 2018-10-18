package com.timo.function;

/**
 * @author Abraham Qin
 * @since 2018/10/18
 */
public interface Formula {
	double calculate(int a);
	default double sqrt(int a){
		return Math.sqrt(a);
	}
}
