package com.ks0100_1;

import java.util.LinkedHashMap;
import java.util.Set;

public class LinkedHashMapTest {

	public static void main(String[] args) {
		// 创建集合对象
		LinkedHashMap<String, String> hm = new LinkedHashMap<String, String>();

		// 创建并添加元素，LinkedHashMap记住添加的顺序，相当于队列
		hm.put("2345", "hello");
		hm.put("1234", "world");
		hm.put("3456", "java");
		hm.put("1234", "javaee");
		hm.put("3456", "android");

		// 遍历
		Set<String> set = hm.keySet();
		for (String key : set) {
			String value = hm.get(key);
			System.out.println(key + "---" + value);
		}
	}

}
