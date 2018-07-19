package com.ks0100_1.clone;

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
//	@Override
//	protected Person clone() throws CloneNotSupportedException { //抛出Clone不支持的异常，异常以后讲
//		return (Person)super.clone();
//	}
	
	/*
	 * 深克隆方法
	 */
//	@Override
	protected Person clone() throws CloneNotSupportedException { //抛出Clone不支持的异常，异常以后讲
		Person p=new Person();
		//p.setName(name);//还是浅克隆
		p.setName(new String(name));
		p.setAge(age);
		if(this.getAddress()!=null){
			Address address=new Address(this.getAddress().toString());
			p.setAddress(address);
		}
		return p;
	}
	
}
