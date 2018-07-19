package com.ks0100_5.code1;

public class Client {

	public static void main(String[] args) {
		/*
		 * 模板方法适用于，算法步骤是固定的场景
		 */
		Template t1=new SubClass1();
		t1.templateMethod();
		System.out.println("-------------------");
		Template t2=new SubClass2();
		t2.templateMethod();
	}

}
