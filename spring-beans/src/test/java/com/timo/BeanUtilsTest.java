package com.timo;

import org.junit.Test;
import org.springframework.beans.*;

/**
 * @author Abraham Qin
 * @since 2018-09-23
 */
public class BeanUtilsTest {
	@Test
	public void testInstantiateBean(){
		//instantiate student class
		Student student = BeanUtils.instantiateClass(Student.class);
		BeanWrapper studentBeanWrapper=PropertyAccessorFactory.forBeanPropertyAccess(student);
		studentBeanWrapper.setPropertyValue(new PropertyValue("name","Abraham Qin"));
		studentBeanWrapper.setPropertyValue("age",1);
		StringBuilder sb = new StringBuilder();
		sb.append("the student name is :").append(student.getName()).append(" age is :").append(student.getAge());
		System.out.println(String.valueOf(sb));

	}
}
