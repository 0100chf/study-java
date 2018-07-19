package com.ks0100_4.code3;

public class Singleton2 {
	private static class SingletonHolder{
		/*
		 * 只有加载内部类SingletonHolder，才会实例化instance
		 */
		private static Singleton2 instance=new Singleton2();
	}
	private Singleton2() {
		System.out.println("实例化Singleton2...");
	}
	//加载SingletonHolder的唯一方式是这个外部类的getInstance()方法
	 public static Singleton2 getInstance() {
		 return SingletonHolder.instance;
	 }
	 
	 public static void main(String[] args) {
		System.out.println("-----");
		//类加载Singleton2的时候，并没有实例化静态内部类的Field instance
		//因为要加载内部类SingletonHolder，只有通过Singleton2的getInstance() 方法，没有其他办法
		//所以这样的设计是很巧妙的
//		Singleton2.getInstance();//只要第一次调用该单例对象的时候，才会实例化
	}
}
