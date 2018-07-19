package com.ks0100_1;

import java.io.Serializable;

public class Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8288440231017834871L;//序列化版本号
	public Person(String name, int age) {
		System.out.println("调用Person构造方法");
		this.name = name;
		this.age = age;
	}
	private String name;
	private int age;
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
	
}
