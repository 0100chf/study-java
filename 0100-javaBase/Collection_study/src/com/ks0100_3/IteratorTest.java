package com.ks0100_3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest {
	public static void main(String[] args) {
		// 创建集合对象
		Collection c = new ArrayList();

		// 创建并添加元素
		c.add("hello");
		c.add("world");
		c.add("java");

		// Iterator iterator():迭代器，集合的专用遍历方式
		Iterator it = c.iterator(); // 实际返回的肯定是子类对象，这里是多态

		Object obj = it.next();
		System.out.println(obj);
		System.out.println(it.next());
		System.out.println(it.next());
		// System.out.println(it.next());//出现异常，java.util.NoSuchElementException
		// ，next下没有这个元素了

		// 最后一个不应该写，所以，我们应该在每次获取前，如果有一个判断就好了
		// 判断是否有下一个元素，有就获取，没有就不搭理它
		
		System.out.println("运行以下代码：");
		if (it.hasNext()) {
			System.out.println(it.next());
		}
		if (it.hasNext()) {
			System.out.println(it.next());
		}
		if (it.hasNext()) {
			System.out.println(it.next());
		}
		if (it.hasNext()) {
			System.out.println(it.next());
		}

		// 最终版代码
		while (it.hasNext()) {
			String s = (String) it.next();
			System.out.println(s);
			// System.out.println(it.next());//简化写法
		}
	}
}
