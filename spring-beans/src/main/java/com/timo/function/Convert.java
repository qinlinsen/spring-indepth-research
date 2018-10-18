package com.timo.function;

/**
 * @author Abraham Qin
 * @since 2018/10/18
 */
@FunctionalInterface
public interface Convert<F,T> {
	/**
	 *从一个对象变成另一个对象
	 * @param from 传入参数
	 * @return  返回结果
	 */
	T convert(F from);
}
