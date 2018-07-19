package com.ks0100_3;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {
	public static void main(String[] args) {
		// 创建集合对象
		ArrayList array = new ArrayList();//只是把List接口，换成ArrayList类

		// 创建元素对象，并添加元素
		array.add("hello");
		array.add("world");
		array.add("java");

		// 遍历
		Iterator it = array.iterator();
		while (it.hasNext()) {
			String s = (String) it.next();
			System.out.println(s);
		}

		System.out.println("-----------");

		for (int x = 0; x < array.size(); x++) {
			String s = (String) array.get(x);
			System.out.println(s);
		}
	}
}
