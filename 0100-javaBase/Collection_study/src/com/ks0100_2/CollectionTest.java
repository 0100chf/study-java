package com.ks0100_2;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionTest {

	public static void main(String[] args) {
		// 测试不带All的方法

		// 创建集合对象
		// Collection c = new Collection(); //错误，因为接口不能实例化
		Collection c = new ArrayList();//ArrayList是Collection一个实现类，大家可以理解为存对象的数组，很常见，之后会讲

		// boolean add(Object obj):添加一个元素
		c.add("hello");
		c.add("world");
		c.add("java");

		System.out.println("c:" + c);// 可以直接打印
		// int size():元素的个数
		System.out.println("size:" + c.size());

		// boolean remove(Object o):移除一个元素
		 System.out.println("remove:" + c.remove("hello"));
		 System.out.println("remove:" + c.remove("javaee"));
		 System.out.println("移除单个元素后 c:" + c);
		 


		// boolean contains(Object o)：判断集合中是否包含指定的元素
		 System.out.println("contains hello？"+c.contains("java"));
		 System.out.println("contains android？"+c.contains("android"));

		// boolean isEmpty()：判断集合是否为空
		System.out.println("isEmpty:"+c.isEmpty());

		// void clear():移除所有元素
		 c.clear();
		 System.out.println("clear 后:" + c);
		 System.out.println("size:" + c.size());
	}

}
