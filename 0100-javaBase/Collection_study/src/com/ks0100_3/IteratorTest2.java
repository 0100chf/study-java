package com.ks0100_3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * 用来测试Collection的remove()方法和Iterator的remove()方法
 */
public class IteratorTest2 {

	public static void main(String[] args) {
		test1();
		//test2();//有异常的方法
		test3();
	}

	public static void test1(){
		System.out.println("-------------test1");
		Collection c=new ArrayList();
		c.add("hello");
		c.add("java");
		c.add("world");
		c.add("java");
		System.out.println("c:"+c);
		Iterator it=c.iterator();
		while(it.hasNext()){
			String s=(String)it.next();
			System.out.println(s);
			if(s.equals("java")){
				it.remove();//next()指向元素后，才能remove该元素
				//c.remove(s);//使用Iterator 迭代过程中，不可修改集合元素，否则会出现异常java.util.ConcurrentModificationException
			}
		}
		System.out.println("c:"+c);
	}
	
	public static void test2(){
		System.out.println("-------------test2");
		Collection c=new ArrayList();
		c.add("hello");
		c.add("world");
		c.add("java");
		for(Object o:c){
			String s=(String)o;
			System.out.println(s);
			if(s.equals("java")){
				c.remove(s);//也会引发 java.util.ConcurrentModificationException
				
			}
		}
	}
	
	//如果要移除某些元素，还可以不用遍历用Collection removeAll 
	public static void test3(){
		System.out.println("-------------test3");
		Collection c=new ArrayList();
		c.add("hello");
		c.add("java");
		c.add("world");
		c.add("java");
		System.out.println("c:"+c);
		//c.remove("java");//只能remove第一个个java
		//System.out.println("remove java 后c:"+c);
		
		Collection c2=new ArrayList();
		c2.add("java");
		c.removeAll(c2);
		System.out.println("remove java 后c:"+c);
		
	}
	
}
