package com.ks0100_1;

import java.util.HashSet;

/*
 * set 判断唯一的标识 是用对象的hashCode()和equals(...)方法 。
 */
public class HashSetTest {

	public static void main(String[] args) {
		// 创建集合对象
		HashSet<Student> hs = new HashSet<Student>();

		// 创建学生对象
		Student s1 = new Student("林青霞", 27);
		Student s2 = new Student("柳岩", 22);
		Student s3 = new Student("王祖贤", 30);
		Student s4 = new Student("林青霞", 27);
		Student s5 = new Student("林青霞", 20);
		Student s6 = new Student("范冰冰", 22);

		// 添加元素
		hs.add(s1);
		hs.add(s2);
		hs.add(s3);
		hs.add(s4);
		hs.add(s5);
		hs.add(s6);

		// set 判断唯一的标识 是用对象的hashCode()和equals(...)方法 。我们可以看Student类的equals()和hashCode()方法
		for (Student s : hs) {
			System.out.println(s.getName() + "---" + s.getAge());
		}
		
	}

}
