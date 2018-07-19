package com.ks0100_1;

/*
 * 与Object_study 工程里的FinalizeTest.java一样
 */
public class FinalizeTest {

	public static void main(String args[]) {
		//new FinalizeTest();//这个匿名对象空间没有变量引用
		 FinalizeTest f= new FinalizeTest();//有名字的对象不会调用finalize()
		 //f=null;//让变量引用地址为空
		 System.gc();//垃圾回收器开始工作,会自动调用对象的finalize()方法。垃圾回收器会耗费更多的系统资源，会与正常的Java程序运行争抢资源，只有在执行大量的对象的释放，才调用垃圾回收最好
	}
	/**
	 * 	当系统中没有引用变量引用该对象时，垃圾回收器(gc)调用此方法来清理该对象的资源。
		如果对象没有重写这个方法，不能调用该方法。（这个方法本来就不让你随便调用）,但是可以重写。

	 */
	public void finalize() throws Throwable {
		
		System.out.println("finalize 方法被调用，当前对象被回收");
		super.finalize();//这个方法也没有，是空的。
	}

}
