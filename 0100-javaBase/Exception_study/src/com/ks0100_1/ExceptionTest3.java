package com.ks0100_1;

public class ExceptionTest3 {

	public static void main(String[] args) {
		/*
		 * 以下方法执行一个，注释其他
		 */
		method1();

		method2();

		method3();

		method4();
	}

	// 一个异常
	public static void method1() {
		System.out.println("方法1----------");
		// 第一阶段
		int a = 10;
		// int b = 2;
		int b = 0;

		try {
			System.out.println(a / b);
			System.out.println("后一行。。。。");// 上一行出现异常，这一行不会执行
		} catch (ArithmeticException ae) {
			System.out.println("除数不能为0");
		}

		// 第二阶段，
		System.out.println("出现异常还能继续执行后面程序....");
	}

	// 两个异常
	public static void method2() {
		System.out.println("方法2，把两个出现异常的语句分开来捕捉----------");
		int a = 10;
		int b = 0;
		try {
			System.out.println(a / b);
		} catch (ArithmeticException e) {
			System.out.println("除数不能为0");
		}

		int[] arr = { 1, 2, 3 };
		try {
			System.out.println(arr[3]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("你访问了不该访问的索引");
		}

		System.out.println("前面出现两个异常，还能继续执行下面程序。。。");
	}

	// 两个异常的处理
	public static void method3() {
		System.out.println("方法3，把两个出现异常的语句一起捕捉----------");
		int a = 10;
		int b = 0;
		int[] arr = { 1, 2, 3 };

		try {
			System.out.println(arr[3]);
			System.out.println(a / b);
		} catch (ArithmeticException e) {
			System.out.println("除数不能为0");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("你访问了不该的访问的索引");
		}

		System.out.println("over");
	}

	public static void method4() {
		System.out.println("方法4----------");
		int a = 10;
		int b = 0;
		int[] arr = { 1, 2, 3 };

		// Exception 异常父类在最后
		try {
			System.out.println(a / b);
			System.out.println(arr[3]);
			System.out.println("这里出现了一个异常，你不太清楚是谁，该怎么办呢?");
		} catch (ArithmeticException e) {
			System.out.println("除数不能为0");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("你访问了不该的访问的索引");
		} catch (Exception e) {
			System.out.println("出问题了");
		}

		// 编译错误， Exception 异常父类前面是不可以的
//		try {
//			System.out.println(a / b);
//			System.out.println(arr[3]);
//			System.out.println("这里出现了一个异常，你不太清楚是谁，该怎么办呢?");
//		} catch (Exception e) {
//			System.out.println("出问题了");
//		} catch (ArithmeticException e) {
//			System.out.println("除数不能为0");
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("你访问了不该的访问的索引");
//		}
		
		System.out.println("over");
	}

}
