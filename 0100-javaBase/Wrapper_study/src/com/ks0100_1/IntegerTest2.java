package com.ks0100_1;

/*
 * 反编译IntegerTest2.java
 * 1.dos进入IntegerTest2.java所在目录
 * 2.编译: javac -encoding utf-8 -d . IntegerTest2.java
 * 3.反编译查看: javap -c com.ks0100_1.IntegerTest2
 * 
 */
public class IntegerTest2 {

	public static void main(String[] args) {
		Integer i = 10;//Integer i = Integer.valueOf(10); 
		i += 20;//i = Integer.valueOf(i.intValue() + 20); //自动拆箱，再自动装箱
		System.out.println("i:" + i);
		//等价于
		/*
		   通过反编译后的代码
		 Integer i = Integer.valueOf(10); 
		 i = Integer.valueOf(i.intValue() + 20); //自动拆箱，再自动装箱
		 System.out.println((new StringBuilder("i:")).append(i).toString());
		 */
	}

}
