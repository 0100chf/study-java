package com.ks0100.c2;

public class Test {

	public static void main(String[] args) {
		Person p1=new Person();
		System.out.println(p1);//自动调用p1.toString()方法
		System.out.println(p1.toString());
		p1.setName("小李");
		p1.setAge(20);
		System.out.println(p1);
		
		Person p2=new Person();
		//解释源码其实还是用==方法
		if(p1.equals(p2)){
			System.out.println("p1和p2相等");
		}else{
			System.out.println("p1和p2不等");
		}
		
		Person p3=p1;
		if(p3.equals(p1)){
			System.out.println("p3和p1相等");
		}else{
			System.out.println("p3和p1不等");
		}
		
		p2.setName("小李");
		p2.setAge(20);
		
		//打开Person类重写的的equals方法，只要类型相等，名字和年龄都相等，对象就相等。
		if(p1.equals(p2)){
			System.out.println("p1和p2相等");
		}else{
			System.out.println("p1和p2不等");
		}
		
		
	}

}
