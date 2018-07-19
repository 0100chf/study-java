package com.ks0100_2.code1;

/*
 * Api接口，Impl1和Impl2实现类都和之前没有差别
 * 简单工厂模式，也就是造了这个工厂类，由工厂类去创建对象
 */
public class Factory {
	public static Api createApi(int condition){
		Api api=null;
		if(condition==1){
			api=new Impl1();
		}else if(condition==2){
			api=new Impl2();
		}
		return api;
	}
}
