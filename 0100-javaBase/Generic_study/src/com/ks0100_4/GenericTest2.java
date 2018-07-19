package com.ks0100_4;

class MyClass<E>{
	//可以接受任意类型的，有的类似Object
	public <T> MyClass (T t){
		System.out.println("t="+t);
	}
	
}
public class GenericTest2 {

	public static void main(String[] args) {
		//String代表E，Integer 代表T
		MyClass<String> c1=new <Integer> MyClass<String>(5);
		//String代表E，Integer 代表T
		MyClass<String> c2=new  MyClass<String>(5);
		//String代表E，Double 代表T
		MyClass<String> c3=new  MyClass<String>(5.5);
		//MyClass c2=new <Integer> MyClass(5);//编译错误，必须显示指定E
		
		//MyClass<String> c4=new  <Integer>  MyClass<>(5);//编译错误，不能在java7使用“菱形语法”<>
		
	}

}
