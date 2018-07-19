package com.ks0100_2;

import java.util.ArrayList;
import java.util.Collection;

import com.ks0100_1.Student;

public class CollectionTest4 {
	public static void main(String[] args) {
		// 创建集合对象
		Collection c = new ArrayList();
		// 创建学生对象
		Student s1 = new Student(" 小李", 27);
		Student s2 = new Student("小王", 30);
		Student s3 = new Student("小明", 22);
		Student s4 = new Student("小张", 23);
		Student s5 = new Student("小陈", 18);
		
		// // 把学生添加到集合
		 c.add(s1);
		 c.add(s2);
		 c.add(s3);
		 c.add(s4);
		 c.add(s5);
		
		 // 把集合转成数组
		 Object[] objs = c.toArray();
		 // 遍历数组
		 for (int x = 0; x < objs.length; x++) {
		
			 Student s = (Student) objs[x];
			 System.out.println(s.getName() + "---" + s.getAge());
		 }
	}
	

}
