package com.ks0100_2;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionTest2 {

	public static void main(String[] args) {
		// 创建集合1
		Collection c1 = new ArrayList();
		c1.add("abc1");
		c1.add("abc2");
		c1.add("abc3");
		c1.add("abc4");
		System.out.println("c1:" + c1);
		// 创建集合2
		Collection c2 = new ArrayList();
		c2.add("abc5");
		c2.add("abc6");
		c2.add("abc7");
		System.out.println("c2:" + c2);
		// boolean addAll(Collection c):添加一个集合的元素
		System.out.println("addAll:" + c1.addAll(c2));
		System.out.println("c1 addAll c2:" + c1);

		// boolean containsAll(Collection c)：判断集合中是否包含指定的集合元素(是一个还是所有)
		// 只有包含所有的元素，才叫包含
		System.out.println("c1 containsAll c2:" + c1.containsAll(c2));

		Collection c3 = new ArrayList();
		c3.add("abc6");
		c3.add("abc7");
		c3.add("abc8");
		System.out.println("c3:" + c3);
		// boolean removeAll(Collection c):移除一个集合的元素(是一个还是所有)
		// 只要c3里面任意元素存在c1中，就被remove，结果返回true，没有元素存在，结果返回false
		System.out.println("c1 removeAll c3:"+c1.removeAll(c3));
		System.out.println("c1:" + c1);
		
		// boolean retainAll(Collection c): 只保留两个集合的交集元素 。
		//  两个集合交集
		System.out.println("c1 retainAll c2:" + c1.retainAll(c2));
		System.out.println("c1:" + c1);
		System.out.println("c2:" + c2);
	}

}
