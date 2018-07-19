package com.ks0100_2;

import java.io.Serializable;

public class Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Person(String name, int age) {
		System.out.println("调用Person构造方法");
		this.name = name;
		this.age = age;
	}
	private String name;
	private int age;
	
	private static String sex;//静态变量
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public static String getSex() {
		return sex;
	}
	public static void setSex(String sex) {
		Person.sex = sex;
	}
	
	
}
