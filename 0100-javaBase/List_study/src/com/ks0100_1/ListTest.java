package com.ks0100_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * list的添加和遍历，还有随机访问（任意访问）
 */
public class ListTest {

	public static void main(String[] args) {
		// 创建集合对象
		List list = new ArrayList();

		// 创建字符串并添加字符串
		list.add("hello");
		list.add("world");
		list.add("java");
		list.add("world");//可以添加重复的对象元素。我们之前学，字符串常量都放在常量池，所以这里的"world"是不是一个对象啊？
		list.add("world");
		
		// 遍历集合
		Iterator it = list.iterator();
		while (it.hasNext()) {
			String s = (String) it.next();
			System.out.println(s);
		}
		
		//这个List接口和之前的Collection接口用法好像啊，名称换一下就好了
		System.out.println("用List 的 size()和get()方法来遍历");
		//List独有的遍历方式,这里用到size()方法(区别数组的length),get方法。
		for (int x = 0; x < list.size(); x++) {

			String s = (String) list.get(x);
			System.out.println(s);
		}
		
		System.out.println("List 比Collection更进步了，可以不用遍历直接访问某个元素了");
		System.out.println("get 0:"+list.get(0));
		System.out.println("get 1:"+list.get(1));
	}

}
