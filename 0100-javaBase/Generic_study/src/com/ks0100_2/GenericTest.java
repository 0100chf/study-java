package com.ks0100_2;

public class GenericTest {

	public static void main(String[] args) {
		Fruit<String> a=new Fruit<String>("苹果");
		System.out.println(a.getInfo());
		Fruit<Double> a2=new Fruit<Double>(5.67);
		System.out.println(a2.getInfo());
	}

}
