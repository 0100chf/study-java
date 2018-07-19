package com.ks0100_2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeTest {

	public static void main(String[] args) {
		writeObject();
		readObject();
	}

	public static void writeObject() {
		ObjectOutputStream os = null;
		try {
			os = new ObjectOutputStream(new FileOutputStream("teacher_out.txt"));
			Person per = new Person("孙悟空", 600);
			Teacher t1 = new Teacher("唐僧", per);
			Teacher t2 = new Teacher("菩提祖师", per);
			if (t1.getStudent() == t2.getStudent() && t1.getStudent() == per) {
				System.out.println("他们的学生都是：" + per.getName());
				System.out.println("只有一个Person对象");
			}

			// 依次将4个对象写入对象流
			os.writeObject(t1);
			os.writeObject(t2);
			os.writeObject(per);
			os.writeObject(t2);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void readObject() {
		ObjectInputStream os = null;
		try {
			os = new ObjectInputStream(new FileInputStream("teacher_out.txt"));
			// 依次读取ObjectInputStream输入流中的4个对象
			Teacher t1 = (Teacher) os.readObject();
			Teacher t2 = (Teacher) os.readObject();
			Person p = (Person) os.readObject();
			Teacher t3 = (Teacher) os.readObject();

			System.out.println("t1 student == p:" + (t1.getStudent() == p));
			System.out.println("t2 student == p:" + (t2.getStudent() == p));
			System.out.println("t2 student == t3:" + (t2 == t3));
			// 通过输出结果，我们看到和实例化对象的时候是一样的，通过一种特殊的序列化编号的算法实现。
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
