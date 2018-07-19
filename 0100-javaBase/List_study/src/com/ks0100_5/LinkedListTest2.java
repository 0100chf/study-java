package com.ks0100_5;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest2 {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add("one");
		list.add("two");
		list.add("three");
		
		System.out.println("<--list中共有 ：" + list.size() + "个元素-->");
		System.out.println("<--list中的内容 ：" + list + "-->");

		String first = (String) list.getFirst();
		String last = (String) list.getLast();
		System.out.println("<--list中第一个元素为 ：" + first + "-->");
		System.out.println("<--list中最后一个元素为 ：" + last + "-->");

		list.addFirst("Begin");
		list.addLast("End");
		System.out.println("<--list中共有 ：" + list.size() + "个元素-->");
		System.out.println("<--list中的内容 ：" + list + "-->");

		//LinkedList 的链表操作用ListIterator，才有next()和previous()方法
		System.out.println("<--使用ListIterator接口操作list-->");
		ListIterator lit = list.listIterator();
		System.out.println("<--下一个索引是" + lit.nextIndex() + "-->");
		lit.next();
		lit.add("zero");
		lit.previous();
		System.out.println("<--上一个索引是" + lit.previousIndex() + "-->");
		lit.previous();
		System.out.println("<--上一个索引是" + lit.previousIndex() + "-->");
		lit.set("Start");
		System.out.println("<--list中的内容 ：" + list + "-->");

		System.out.println("<--删除list中的zero-->");
		lit.next();
		lit.next();
		lit.remove();
		System.out.println("<--list中的内容 ：" + list + "-->");

		System.out.println("<--删除list中的第一个和最后一个元素-->");
		list.removeFirst();
		list.removeLast();

		System.out.println("<--list中共有 ：" + list.size() + "个元素-->");
		System.out.println("<--list中的内容 ：" + list + "-->");
	}

}
