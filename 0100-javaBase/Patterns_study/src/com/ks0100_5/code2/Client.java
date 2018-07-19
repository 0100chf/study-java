package com.ks0100_5.code2;


public class Client {

	public static void main(String[] args) {
		
		Template t1=new SubClass1();
		t1.templateMethod();
		System.out.println("-------------------");
		Template t2=new SubClass2();
		t2.templateMethod();
	}

}
