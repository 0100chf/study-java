package com.ks0100.c2;

public class FinalizeTest {

	public static void main(String args[]) {
		FinalizeTest f= new FinalizeTest();//有名字的对象不会调用finalize()
		new FinalizeTest();//这个匿名对象，地址空间没有变量引用
		 //f=null;//让变量引用地址为空
		 System.gc();//垃圾回收器开始工作,会自动调用对象的finalize()方法。gc()方法之后还会讲
	}
	
	/**
	 * 	当系统中没有引用变量引用该对象时，垃圾回收器(gc)调用此方法来清理该对象的资源。
		如果对象没有重写这个方法，不能调用该方法。（这个方法本来就不让你随便调用）,但是可以重写。
		我们这个例子，程序运行完毕以后，直接把内存释放掉，不能感受到垃圾回收有什么用处；
		但是，如果java程序一直在运行过程，如果没有gc垃圾回收，那么对象所用的空间没有被释放掉，会造成内存泄漏（也就是无限制的去占用系统内存），最终造成程序或系统奔溃。
		所以，有了gc，就能够回收一部分内存，让java程序保持在一个健康的水平中使用。
	 */
	public void finalize() throws Throwable {
		
		System.out.println("finalize 方法被调用，当前对象被回收");
	}

}
