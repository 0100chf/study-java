package com.ks0100_4;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Person implements Externalizable{
	
	public Person(){} //必须得声明无参构造方法
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
	
	//实现Externalizable接口必须得实现以下两个方法
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("writeExternal()------------");
		out.writeObject(name);
		out.writeInt(age);
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("readExternal()------------");
		this.name=(String)in.readObject();
		this.age=in.readInt();
	}
	
}
