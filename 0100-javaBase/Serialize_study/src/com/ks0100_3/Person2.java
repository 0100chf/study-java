package com.ks0100_3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person2 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3099245089867264647L;
	public Person2(String name, int age) {
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
	//writeObject(...)方法是特殊签名的方法，不是实现接口的方法
	private void writeObject(ObjectOutputStream out) throws IOException{
		System.out.println("运行Person2 writeObject(...)方法");
		out.writeObject("加密后的名字:"+name);
	}
	//readObject(...)方法是特殊签名的方法，不是实现接口的方法
	private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException{
		System.out.println("运行Person2 readObject(...)方法");
		this.name= (String)in.readObject();
	}
}
