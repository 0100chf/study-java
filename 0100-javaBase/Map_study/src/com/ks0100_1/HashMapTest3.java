package com.ks0100_1;

import java.util.HashMap;
import java.util.Set;

/*
 * 用对象作为key，需要重写对象的hashCode()和equals()方法
 */
public class HashMapTest3 {

	public static void main(String[] args) {
		// 创建集合对象
		HashMap<Student, String> hm = new HashMap<Student, String>();

		// 创建学生对象
		Student s1 = new Student("貂蝉", 27);
		Student s2 = new Student("王昭君", 30);
		Student s3 = new Student("西施", 33);
		Student s4 = new Student("杨玉环", 35);
		Student s5 = new Student("貂蝉", 27);

		// 添加元素，key为Student对象，值是字符串
		//要求：如果两个对象的成员变量值都相同，，也就是Student的成员变量name和age都相同，则为同一个对象。
		//需要重写Student的hashCode()和equals()方法
		hm.put(s1, "8888");
		hm.put(s2, "6666");
		hm.put(s3, "5555");
		hm.put(s4, "7777");
		hm.put(s5, "9999");

		// 遍历
		Set<Student> set = hm.keySet();
		for (Student key : set) {
			String value = hm.get(key);
			System.out.println(key.getName() + "：" + key.getAge() + "---" + value);
		}
		
		s1.setAge(30);//修改了key对象的变量，那么找不到value了。所以不要用可变对象做key
		System.out.println("s1:"+hm.get(s1));
	}

}
