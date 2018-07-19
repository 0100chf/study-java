package com.ks0100_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
 * ListIterator接口，主要用在List接口的迭代方法listIterator()
 */
public class ListIteratorDemo {

	public static void main(String[] args) {
		// 创建List集合对象
		List list = new ArrayList();
		list.add("hello");
		list.add("world");
		list.add("java");

		System.out.println("用listIterator()来往后遍历：");//类似 Iterator接口的next()方法
		// ListIterator listIterator()
		ListIterator lit = list.listIterator(); // 子类对象
		while (lit.hasNext()) {
			String s = (String) lit.next();
			System.out.println(s);
		}
		System.out.println("1-----------------");

		System.out.println("lit.previous():"+lit.previous());
		System.out.println("lit.previous():"+lit.previous());
		System.out.println("lit.previous():"+lit.previous());
		// NoSuchElementException
		// System.out.println(lit.previous());
		System.out.println("2-----------------");
		
		previouList(lit);

		// 迭代器
		Iterator it = list.iterator();
		while (it.hasNext()) {
			String s = (String) it.next();
			System.out.println(s);
		}
		System.out.println("3-----------------");
		//ListIterator和Iterator无关
		previouList(lit);
		while (lit.hasNext()) {
			String s = (String) lit.next();
			System.out.println(s);
		}
		System.out.println("4-----------------");
		//大家可以想像一下，有一个游标，在上面一个循环已经lit.next()到最后一个元素，那么接下来就可以往前遍历了。
		previouList(lit);
	}
	
	
	public static void previouList(ListIterator lit){
		System.out.println("-----------------开始往前遍历元素--");
		while (lit.hasPrevious()) {
			String s = (String) lit.previous();
			System.out.println(s);
		}
		System.out.println("-----------------往前遍历结束--");
		
	}

}
