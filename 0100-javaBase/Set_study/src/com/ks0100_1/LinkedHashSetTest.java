package com.ks0100_1;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {

	public static void main(String[] args) {
		// 创建集合对象
		LinkedHashSet<String> hs = new LinkedHashSet<String>();

		// 创建并添加元素
		hs.add("hello");
		hs.add("world");
		hs.add("java");
		hs.add("world");
		hs.add("java");
		hs.add("111");

		//LinkedHashSet 元素是按顺序放的，而且唯一
		for (String s : hs) {
			System.out.println(s);
		}
	}

}
