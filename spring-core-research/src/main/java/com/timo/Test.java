package com.timo;

import com.alibaba.fastjson.JSON;
import com.timo.model.Dog;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		Log logger = LogFactory.getLog(Test.class);
		JSON json;
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-beans.xml");
		Dog dog = ac.getBean(Dog.class);
		logger.info("dog="+dog);
	}
}
