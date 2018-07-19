package com.ks0100_3;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;

public class Person3 implements Serializable{
	public Person3(String name, int age) {
		System.out.println("调用Person构造方法");
		this.name = name;
		this.age = age;
	}
	private String name;
	private transient int age;
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
	
	//writeReplace(...)方法是特殊签名的方法，不是实现接口的方法
	private Object writeReplace() throws ObjectStreamException{
		System.out.println("Person3 writeReplace()---");
		ArrayList<Object> list =new ArrayList<Object>();
		list.add(name);
		list.add(age);
		return list;
	}
}
