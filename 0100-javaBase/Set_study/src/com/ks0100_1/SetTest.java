package com.ks0100_1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		// 创建集合对象
		Set<String> set = new HashSet<String>();//泛型，以后讲，这里是强制集合元素类型为String

		// 创建并添加元素
		set.add("hello");
		set.add("java");
		set.add("world");
		set.add("java");//重复的数据添加后，不会产生新的元素，因为set里面的元素是唯一的
		set.add("world");
		//虽然每次遍历都显示的顺序一样，但是它不保证该顺序恒久不变
		for (String s : set) {
			System.out.println(s);
		}
		System.out.println("用Iterator来遍历----");
		Iterator it=set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
