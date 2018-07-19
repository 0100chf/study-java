package com.ks0100_3;

public class Client {
	public static void main(String[] args) {
		Factory factory=new Factory();
		factory.factoryMethod(1, "测试1");
		factory.factoryMethod(2, "测试2");
		
		System.out.println("又添加了实现类的方法，那么修改的时候，一种是直接修改以前的Factory内的方法，另一种是写新的工厂类，重写原来的方法:");
		Factory2 factory2=new Factory2();
		factory2.factoryMethod(3, "测试3");
		factory2.factoryMethod(1, "测试1");
	}
}
