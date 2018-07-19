package com.ks0100_3;

import java.io.Serializable;

//public class Fruit<T extends Number> {
//public class Fruit<T extends Number & String > {//错误不能继承多个类
public class Fruit<T extends Number & Serializable > {//但是可以继承多个接口或抽象类
	private T info;
	public Fruit(T info){
		this.info=info;
	}
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public static void main(String[] args) {
		Fruit<Integer> f1=new Fruit(123);
		Fruit<Double> f2=new Fruit(12.3);
		//Fruit<String> f3=new Fruit("0100");//编译错误，类型参数必须继承Number，是Number的子类
	}
	
}
