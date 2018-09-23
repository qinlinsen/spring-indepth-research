package com.timo;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyAccessorFactory;

import java.beans.PropertyDescriptor;

/**
 * @author Abraham Qin
 */
public class BeanWrapperTest {
	public  void beanWrapperMainUsage(){
		User user = new User();
		BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(user);
		//给属性赋值
		beanWrapper.setPropertyValue("userName","Abraham Qin");
		beanWrapper.setPropertyValue("age",20);
		PropertyDescriptor userNameDescriptor = beanWrapper.getPropertyDescriptor("userName");
		Class<?> agePropertyType = beanWrapper.getPropertyDescriptor("age").getPropertyType();
		System.out.println("user's name is :"+user.getUserName());
		System.out.println("user's age is :"+user.getAge());
		System.out.println("user name's type is :"+userNameDescriptor.getPropertyType());
		System.out.println("user age's type is :"+agePropertyType);
	}

	/**
	 * {@link java.lang.Class#isAssignableFrom(Class)}
	 * 这个方法的用法是：a.isAssignableFrom(b)判断a是不是b的同类，父类
	 */
	public void classAssignableFromTest(){
		System.out.println(BeanWrapperImpl.class.isAssignableFrom(BeanWrapper.class));
		System.out.println(BeanWrapper.class.isAssignableFrom(BeanWrapperImpl.class));
	}
	public static void main(String[] args) {
		BeanWrapperTest beanWrapperTest = new BeanWrapperTest();
		beanWrapperTest.beanWrapperMainUsage();
		beanWrapperTest.classAssignableFromTest();
	}
	private class User{
		private String userName;
		private Integer age;

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}
	}
}
