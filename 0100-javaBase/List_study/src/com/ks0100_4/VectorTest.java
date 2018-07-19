package com.ks0100_4;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		// 创建集合对象
		Vector v = new Vector();

		// 添加功能
		v.addElement("hello");
		v.addElement("world");
		v.addElement("java");

		// 遍历
		for (int x = 0; x < v.size(); x++) {
			String s = (String) v.elementAt(x);
			System.out.println(s);
		}

		System.out.println("1------------------");
		//这种遍历不常用
		Enumeration en = v.elements(); // 返回的是实现类的对象
		while (en.hasMoreElements()) {
			String s = (String) en.nextElement();
			System.out.println(s);
		}
		System.out.println("2------------------");
		//Vector类的方法和下面的一样
		Vector v2 = new Vector();
		
		// 添加功能
		v2.add("hello");
		v2.add("world");
		v2.add("java");
		//更常用的是这种遍历方式
		Iterator it=v2.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}

}
