package com.ks0100_2;

//public class Apple extends Fruit<T>{ //错误的语法
public class Apple extends Fruit{ //不建议这样做，会有警告

	public Apple(String info) {
		super(info);
	}
	public String getInfo() {
		return super.getInfo().toString();
	}
	public void setInfo(String info) {
		super.setInfo(info);
	}
}
