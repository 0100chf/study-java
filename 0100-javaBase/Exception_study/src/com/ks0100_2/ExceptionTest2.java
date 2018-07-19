package com.ks0100_2;
/*
 * throw:如果出现了异常情况，我们可以把该异常抛出，这个时候的抛出的应该是异常的对象。
 * 
 * throws和throw的区别(面试题)
	throws
		用在方法声明后面，跟的是异常类名
		可以跟多个异常类名，用逗号隔开
		表示抛出异常，由该方法的调用者来处理
		throws表示出现异常的一种可能性，并不一定会发生这些异常
	throw
		用在方法体内，跟的是异常对象名
		只能抛出一个异常对象名
		表示抛出异常，由方法体内的语句处理
		throw则是抛出了异常，执行throw则一定抛出了某种异常
 */

public class ExceptionTest2 {

	public static void main(String[] args) {
		/**
		 * 以上三个方法分别打开注释执行
		 */
		
//	    method();//不处理异常，程序会中断
		
//	    method2();//MyCheckedException 已经在方法内处理，这里不需要再捕捉异常了
		
		try {
			method3();//必须try catch
		} catch (MyCheckedException e) {
			e.printStackTrace();
		}
		
	}

	public static void method() {
		int a = 10;
		int b = 0;
		if (b == 0) {
			//Runtime Exception最轻松了
			throw new MyRuntimeException("MyRuntimeException：除数不能是0");
		} else {
			System.out.println(a / b);
		}
	}

	public static void method2() {
		int a = 10;
		int b = 0;
		if (b == 0) {
			//Checked Exception一定要处理，好麻烦啊
			//这里表示在method2()方法里面内部处理MyCheckedException
			try {
				throw new MyCheckedException("MyCheckedException：除数不能是0");
			} catch (MyCheckedException e) {}
		} else {
			System.out.println(a / b);
		}
	}
	
	public static void method3() throws MyCheckedException {
		int a = 10;
		int b = 0;
		if (b == 0) {
			//通过方法标识throws MyCheckedException，method3()方法不处理MyCheckedException
			throw new MyCheckedException("MyCheckedException：除数不能是0");
		} else {
			System.out.println(a / b);
		}
	}
	
	//可以throws 好多异常
	public static void method4() throws MyCheckedException,MyRuntimeException,ArithmeticException {
		int a = 10;
		int b = 0;
		if (b == 0) {
			throw new MyCheckedException("MyCheckedException：除数不能是0");
		} else {
			System.out.println(a / b);
		}
	}
}

class Sub extends ExceptionTest2{
	
	//public static void method4() throws  Exception{}//编译错误，子类重写父类方法，不能throws比父类“更大”的异常
	
	public static void method4() throws  MyCheckedException{}
}
