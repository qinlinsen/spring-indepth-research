package com.timo.springcore;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * @author qinlinsen
 */
public class PropertiesLoaderUtilsTest {
	@Test
	public void testPropertiesLoadUtils(){
		try {
			//获取资源
			ClassPathResource resource = new ClassPathResource("test.properties", PropertiesLoaderUtilsTest.class);
			Properties properties = PropertiesLoaderUtils.loadProperties(resource);
			//获得test.properties的值
			String value = properties.getProperty("a");
			System.out.println(value);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}
}
