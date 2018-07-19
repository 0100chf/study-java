package com.ks0100_3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * 用特殊签名的方法writeObject(...)和readObject(...)来实现序列化
 * 
 */
public class SerializeTest2 {

	public static void main(String[] args) {
		ObjectOutputStream out = null;
		ObjectInputStream in=null;
		try {
			//序列化
			out = new ObjectOutputStream(new FileOutputStream("serializeTest2_out.txt"));
			Person2 person = new Person2("孙悟空", 600);
			out.writeObject(person);
			System.out.println("开始反序列化--------");
			//反序列化
			in = new ObjectInputStream(new FileInputStream("serializeTest2_out.txt"));
			Person2 p1=(Person2)in.readObject();
			System.out.println("姓名:"+p1.getName()+";年龄:"+p1.getAge());
			
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
