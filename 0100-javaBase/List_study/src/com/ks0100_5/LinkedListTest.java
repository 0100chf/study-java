package com.ks0100_5;

import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
		// 创建集合对象
		LinkedList link = new LinkedList();

		// 添加元素
		link.add("hello");
		link.add("world");
		link.add("java");
		System.out.println("link:" + link);
		// public void addFirst(Object e)
		link.addFirst("javaee");
		// public void addLast(Object e)
		link.addLast("android");
		System.out.println("link:" + link);
		
		// public Object getFirst()
		 System.out.println("getFirst:" + link.getFirst());
		// public Obejct getLast()
		 System.out.println("getLast:" + link.getLast());

		// public Object removeFirst()
		System.out.println("removeFirst:" + link.removeFirst());
		// public Object removeLast()
		System.out.println("removeLast:" + link.removeLast());

		// 输出对象名
		System.out.println("link:" + link);
		
	}
}
