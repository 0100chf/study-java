package com.ks0100_3;

public class ThreadExceptionTest implements Runnable{

	public void run(){
		method1();
	}
	
	public static void method1(){
		method2();
	}
	public static void method2(){
		method3();
	}
	public static void method3() {
		int i=5/0;
	}
	public static void main(String[] args) {
		new Thread(new ThreadExceptionTest()).start();
		//最后一行是java.lang.Thread.run方法
	}

}
