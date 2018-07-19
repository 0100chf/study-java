package com.ks0100_5.code1;

public class SubClass1 extends Template{

	protected void method1() {
		System.out.println("这是SubClass1的method1");
	}
	@Override
	protected void method3() {
		System.out.println("这是SubClass1的method3");
	}

	@Override
	protected void method4() {
		System.out.println("这是SubClass1的method4");
	}

}
