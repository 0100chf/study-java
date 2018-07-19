package com.ks0100.c3;

import java.util.Objects;

public class ObjectsTest {


	public static void main(String[] args)  {
		
		/*
		 * Objects.hashCode(…) 和 Objects.toString(…) 与之前的Object方法的作用是一样的
		 */
		ObjectsTest ot1=new ObjectsTest();
		System.out.println(Objects.hashCode(ot1));
		System.out.println(ot1.hashCode());
		System.out.println(Objects.toString(ot1));
		System.out.println(ot1.toString());
		
		/*
		 * Objects.hashCode(…) 和 Objects.toString(…) 方法
		 * 如果参数对象是null的话，不会抛出异常，即空指针安全。
		 */
		ObjectsTest ot=null;
//		System.out.println(ot.hashCode());//空指针异常
//		System.out.println(ot.toString());//空指针异常
		
		System.out.println(Objects.hashCode(ot));
		System.out.println(Objects.toString(ot));
		
		
		System.out.println(Objects.requireNonNull(ot,"对象是空"));
		//不用requireNonNull(...)方法
//		if(ot==null){
//			throw new Exception("对象是空");//异常以后讲
//		}
	}

}
