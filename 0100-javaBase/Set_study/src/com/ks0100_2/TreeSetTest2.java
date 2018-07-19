package com.ks0100_2;

import java.util.TreeSet;

public class TreeSetTest2 {

	public static void main(String[] args) {
		// 创建集合对象
		TreeSet<Student> ts = new TreeSet<Student>();

		// 创建元素
		Student s1 = new Student("奶茶妹妹", 27);
		Student s2 = new Student("章子仪", 29);
		Student s3 = new Student("汤唯", 23);
		Student s4 = new Student("奶茶妹妹", 27);
		Student s5 = new Student("baby", 22);
		Student s6 = new Student("林青霞", 40);
		Student s7 = new Student("范冰冰", 22);

		// 添加元素，按照Student类的实现的compareTo()方法来，写排序规则。
		ts.add(s1);
		ts.add(s2);
		ts.add(s3);
		ts.add(s4);
		ts.add(s5);
		ts.add(s6);
		ts.add(s7);

		// 遍历，按照Student类的实现的compareTo()方法来，写排序规则。
		for (Student s : ts) {
			System.out.println(s.getName() + "---" + s.getAge());
		}
	}

}
