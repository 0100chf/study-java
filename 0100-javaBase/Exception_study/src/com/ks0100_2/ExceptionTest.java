package com.ks0100_2;

import java.io.FileNotFoundException;

public class ExceptionTest {

	public static void main(String[] args) {
		 test1();
		 
		 try {
			test1();//可以处理异常，也可以不处理
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
		 
//		以下代码错误，方法中 throws 了ArithmeticException，就一定要处理这个异常，或者用父类Exception 捕捉
//		 try {
//			test1();
//		} 
//		 catch (FileNotFoundException e) {}
		 
		 //test2();//语法错误，Checked异常一定要强制处理异常
		 try {
			test2();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		 //以下可以用父类捕获处理异常
		try {
			test2();
		} catch (Exception e) {}
		 
		try {
			test2();
		} catch (Throwable e) {} 
		
		try {
			test3();
		} catch (MyCheckedException e) { //处理自定义的Checked异常
			e.printStackTrace();
		} 
		
		test4();//不需要处理自定义的Runtime异常
		
	}
	
	public static void test1() throws ArithmeticException { 
		System.out.println("test1方法，用throws 标志 RuntimeException 的子类ArithmeticException----------");
	}
	
	public static void test2() throws FileNotFoundException { 
		System.out.println("test2方法，用throws标志 非RuntimeException的子类FileNotFoundException，需要try catch ----------");
	}
	
	public static void test3() throws MyCheckedException{
		System.out.println("test3方法，用throws标志 MyCheckedException ----------");
	}
	
	public static void test4() throws MyRuntimeException{
		System.out.println("test3方法，用throws标志 MyRuntimeException ----------");
	}
}
