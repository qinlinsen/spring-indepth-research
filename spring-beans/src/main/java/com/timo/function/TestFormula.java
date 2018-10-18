package com.timo.function;

/**
 * @author Abraham Qin
 * @since 2018/10/18
 */
public class TestFormula implements Formula {
	@Override
	public double calculate(int a) {
		return 0;
	}

	public static void main(String[] args) {
		double result = new TestFormula().sqrt(2);
		System.out.println(result);
	}
}
