package com.ks0100_4;

import java.util.ArrayList;
import java.util.List;

public class GenericTest3 {

	public static void main(String[] args) {
		Fruit<Integer> f=new Fruit<Integer>(10);
		Integer info=f.getInfo();
		System.out.println(info);
		Fruit f2=f;
		/*
		 * 编译错误
		 * 把带泛型信息的变量f赋值给不带泛型信息的变量f2，编译器就会丢失f对象的泛型信息
		 */
		//Integer info2=f2.getInfo(); 
		Fruit<Integer> f3=f;
		Integer info3=f3.getInfo(); 
		System.out.println(info3);
		
		System.out.println("避免类型转换问题------");
		List<Integer> li=new ArrayList<Integer>();
		li.add(1);
		li.add(2);
		List list=li;//编译通过
		List<String> list2=list;
		System.out.println(list2.get(0));//编译正常，但是运行时类型转换错误
		
	}

}
