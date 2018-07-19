package com.ks0100_2;

//public class Apple<Abc> //T也可以替换成 Abc，
public class Fruit<T> {
	private T info;
	//info类型不固定，是泛型
	public Fruit(T info){
		this.info=info;
	}
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	
}
