package com.ks0100_4.code2;

public class Client {

	public static void main(String[] args) {
		System.out.println("懒汉单例：------------");
		System.out.println("Singleton.test："+Singleton.test);
		Singleton s1;
		System.out.println("开始实例化s1:");
		s1 = Singleton.getInstance();
		Singleton s11=Singleton.getInstance();
		if(s1==s11){
			System.out.println("s1和s11是 懒汉单例");
		}
		s1.print("abc");
		System.out.println("饿汉单例：------------");
		//根据类加载的时机：3.访问静态Field的时候，类就加载；大家可以试一下2.调用类的静态方法
		System.out.println("Singleton2.test："+Singleton2.test);
		Singleton2 s2;
		System.out.println("开始实例化s2:");
		s2 = Singleton2.getInstance();
		Singleton2 s22=Singleton2.getInstance();//Singleton2类的对象已经实例化过了，不会再实例化
		if(s2 == s22){
			System.out.println("s2和s22是 饿汉单例");
		}
		s2.print("cde");
		//大家还可以看Singleton和Singleton2的main方法，了解类加载
	}

}
