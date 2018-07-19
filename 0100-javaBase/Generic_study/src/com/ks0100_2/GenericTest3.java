package com.ks0100_2;

public class GenericTest3 {

	public static void main(String[] args) {
		Fruit<String> a=new Fruit<String>("苹果");
		Fruit<Double> a2=new Fruit<Double>(5.67);
		System.out.println(a.getClass()==a2.getClass());
		//结果是true,说明Fruit<String>和Fruit<Double>都不是新的类
		
	}

}
