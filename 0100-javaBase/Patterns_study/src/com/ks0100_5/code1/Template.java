package com.ks0100_5.code1;

public abstract class Template {
	
	/*
	 * 模板方法，定义算法骨架
	 */
	public final void templateMethod(){
		this.method1();
		this.method2();
		this.method3();
		this.method4();
	}
	
	/*
	 *以下各种方法，根据实际情况修改修饰符。
	 *不让子类访问的可以改成private，不让子类覆盖可以加final，也可以该访问权限为public等等 
	 */
	
	protected void method1(){
		System.out.println("这是方法1");
	}
	
	protected final void method2(){
		System.out.println("这是方法2");
	}
	
	protected abstract void method3();
	
	protected abstract void method4();
}
