package com.ks0100_4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class ExternalizableTest {

	public static void main(String[] args) {
		ObjectOutputStream out = null;
		ObjectInputStream in=null;
		try {
			//序列化
			out = new ObjectOutputStream(new FileOutputStream("externalizableTest_out.txt"));
			Person person = new Person("孙悟空", 600);
			out.writeObject(person);
			System.out.println("开始反序列化--------");
			//反序列化
			in = new ObjectInputStream(new FileInputStream("externalizableTest_out.txt"));
			Person p=(Person)in.readObject();
			System.out.println("姓名:"+p.getName()+";年龄:"+p.getAge());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
