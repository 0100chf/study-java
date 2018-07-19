package com.ks0100_2;

public class Fruit2<T> {
	
	//private static T info2;//错误，不能在静态Field声明使用在类上面定义的泛型类型形参
	//static void setInfo2(T info2){}//错误，不能在静态方法声明使用在类上面定义的泛型类型形参
	private T info;
	//info类型不固定，是泛型
	public Fruit2(T info){
		this.info=info;
	}
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public static void main(String[] args) {
		Fruit2<String> f=new Fruit2<String>("");
		//错误，instanceof 运算符后面不能使用泛型类
		//if(f instanceof Fruit2<String> ){}
		if(f instanceof Fruit2){
			
		}
	}
}
