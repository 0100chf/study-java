package com.ks0100_2;

public class GenericTest2 {

	public static void main(String[] args) {
		Apple apple=new Apple("苹果");
		System.out.println(apple.getInfo());
		Orange orange=new Orange(100);
		System.out.println(orange.getInfo());
	}

}
