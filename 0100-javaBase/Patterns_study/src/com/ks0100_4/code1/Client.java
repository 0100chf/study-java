package com.ks0100_4.code1;

public class Client {

	public static void main(String[] args) {
		/*
		 * 以下编译错误，Singleton的构造方法是私有的，不能实例化对象，
		 * 这样避免实例化多个对象，只能用Singleton提供的静态方法来引用一个实例
		 */
		//Singleton s=new Singleton();//
		
		for(int i=0;i<10;i++){
			Singleton s1=Singleton.getInstance();
			//System.identityHashCode(...)方法，返回的是对象的唯一标识，和内存地址有关
			//打印出的数字，就好像内存地址的门牌号码一样
			System.out.println(System.identityHashCode(s1));//地址都一样说明，只引用了一个实例的地址，就是单例的意思
		}
	}

}
