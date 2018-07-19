package com.ks0100.c3;

public class Person implements Cloneable{
	private String name;
	private int age;
	private Address address;
	
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

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	/*
	 * 这个super.clone()方法是一个浅克隆的方法，实质上是拷贝成员变量的地址。速度块，不安全。
	 */
	@Override
	public Person clone() throws CloneNotSupportedException { //抛出Clone不支持的异常，异常以后讲
		return (Person)super.clone();//使用Object 的clone()方法，是浅克隆
	}
	
	/*
	 * 深克隆方法
	 */
//	@Override
//	public Person clone() throws CloneNotSupportedException { //抛出Clone不支持的异常，异常以后讲
//		Person p=new Person();
//		//p.setName(name);//这样还是赋值成员变量地址
//		p.setName(new String(name));
//		p.setAge(age);
//		if(this.getAddress()!=null){
//			Address address=new Address(this.getAddress().toString());
//			p.setAddress(address);
//		}
//		return p;
//	}
	
}
