package com.ks0100_1;

import java.util.ArrayList;
import java.util.List;

/*
 * 和index(索引)有关的方法,add、remove、set
 */
public class ListTest3 {

	public static void main(String[] args) {
		// 创建集合对象
		List list = new ArrayList();

		// 添加元素
		list.add("hello");
		list.add("world");
		list.add("java");

		// void add(int index,Object element):在指定位置添加元素
		list.add(1, "android");// 没有问题,原来索引位置上的元素往后移
		// IndexOutOfBoundsException
		//list.add(11, "javaee");// 有问题，索引不能超过当前list最大索引
		list.add(3, "javaee"); // 没有问题
		//list.add(4, "javaee"); // 有问题
		System.out.println("list:" + list);
		

		// Object remove(int index)：根据索引删除元素,返回被删除的元素
		 System.out.println("remove:" + list.remove(1));
		// IndexOutOfBoundsException
		// System.out.println("remove:" + list.remove(11));
		 System.out.println("remove 后的list:" + list);
		 
		// Object set(int index,Object element):根据索引修改元素，返回被修饰的元素
		System.out.println("set :" + list.set(1, "javaee"));

		System.out.println("list:" + list);
	}

}
