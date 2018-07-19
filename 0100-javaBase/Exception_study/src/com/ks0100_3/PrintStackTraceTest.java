package com.ks0100_3;
class MyException extends RuntimeException{
	MyException(){}
	MyException(String msg){
		super(msg);
	}
}


public class PrintStackTraceTest {

	public static void main(String[] args) {
		method1();
		//我们可以找到异常的源头，并跟踪到异常一路触发的过程。
		/*
		 * 第一行的信息详细显示了异常的类型和异常的详细消息。
		 * 接下来跟踪栈记录程序中所有的异常发生点，各行显示被调用方法中执行的停止位置，
		 * 并标明类、类中的方法、与故障点对应的文件的行。
		 * 一行行往下看，跟踪栈总是最内部的被调用方法逐渐上传，直到最外部业务操作的起点，
		 * 通常就是程序的入口main方法或Thread类的run方法（多线程）。

		 */
	}
	public static void method1(){
		method2();
	}
	public static void method2(){
		method3();
	}
	public static void method3() {
		throw new MyException("自定义异常信息");
	}

}
