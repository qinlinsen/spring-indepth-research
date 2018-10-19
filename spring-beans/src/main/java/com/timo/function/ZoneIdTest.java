package com.timo.function;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

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
		long hour = ChronoUnit.SECONDS.between(berlinLocalTime, shanghaiLocalTime);
		System.out.println("hour="+hour);
		System.out.println(21600/3600);
	}
}
