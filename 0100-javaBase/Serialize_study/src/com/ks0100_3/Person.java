package com.ks0100_3;

import java.io.Serializable;

public class Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5005768363891285773L;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	private String name;
	private transient int age;//不被序列化
	
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
