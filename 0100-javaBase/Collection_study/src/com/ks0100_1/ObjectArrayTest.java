package com.ks0100_1;

public class ObjectArrayTest {

	public static void main(String[] args) {
		// 创建学生数组(对象数组)。
		Student[] students = new Student[5];

		// 创建5个学生对象，并赋值。
		Student s1 = new Student(" 小李", 27);
		Student s2 = new Student("小王", 30);
		Student s3 = new Student("小明", 22);
		Student s4 = new Student("小张", 23);
		Student s5 = new Student("小陈", 18);

		// 把C步骤的元素，放到数组中。
		students[0] = s1;
		students[1] = s2;
		students[2] = s3;
		students[3] = s4;
		students[4] = s5;


		// 遍历
		for (int x = 0; x < students.length; x++) {
			
			Student s = students[x];
			System.out.println(s.getName() + "---" + s.getAge());
		}
		// 遍历 2
		for(Student s:students){
			System.out.println(s);
		}
	}

}
