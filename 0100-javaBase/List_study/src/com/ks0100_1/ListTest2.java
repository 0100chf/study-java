package com.ks0100_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/*
 * 可以存储任何对象，有别于数组
 * 这里同时保存Student对象和字符串对象
 */
public class ListTest2 {

	public static void main(String[] args) {
		// 创建集合对象
		List list = new ArrayList();

		// 创建学生对象
		Student s1 = new Student("小王", 30);
		Student s2 = new Student("小李", 24);

		//可以添加任意类型的元素
		list.add(s1);
		list.add("这是字符串");
		list.add(s2);
		
		// 遍历
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object o=it.next();
			if( o instanceof Student){
				Student s = (Student)o;
				System.out.println(s.getName() + "---" + s.getAge());
			}else if(o instanceof String){
				System.out.println(o);
			}
			
		}
	}

}
