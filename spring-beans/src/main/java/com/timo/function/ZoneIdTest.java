package com.timo.function;

import java.time.LocalTime;
import java.time.ZoneId;

/**
 * @author Abraham Qin
 * @since 2018/10/19
 */
public class ZoneIdTest {
	public static void main(String[] args) {
		ZoneId berlin = ZoneId.of("Europe/Berlin");
		ZoneId shanghai = ZoneId.of("Asia/Shanghai");
		System.out.println(berlin.getRules());
		System.out.println(shanghai.getRules());

		LocalTime berlinLocalTime = LocalTime.now(berlin);
		LocalTime shanghaiLocalTime = LocalTime.now(shanghai);
		System.out.println();
	}
}
