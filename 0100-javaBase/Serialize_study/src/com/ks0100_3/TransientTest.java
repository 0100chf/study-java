package com.ks0100_3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class TransientTest {

	public static void main(String[] args) {
		ObjectOutputStream out = null;
		ObjectInputStream in=null;
		try {
			//序列化
			out = new ObjectOutputStream(new FileOutputStream("transientTest_out.txt"));
			Person person = new Person("孙悟空", 600);
			out.writeObject(person);
			//反序列化
			in = new ObjectInputStream(new FileInputStream("transientTest_out.txt"));
			Person p1=(Person)in.readObject();
			System.out.println("姓名:"+p1.getName()+";年龄:"+p1.getAge());
			//年龄是0，取int Field默认值0，说明age没有被序列化
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
