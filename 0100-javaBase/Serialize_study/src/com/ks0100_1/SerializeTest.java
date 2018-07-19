package com.ks0100_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeTest {

	public static void main(String[] args) {
		System.out.println("-------把person对象通过序列化保存到文件中--------");
		writeObject() ;
		System.out.println("-------反序列化恢复使用对象----");
		readObject();
	}

	public static void writeObject() {
		ObjectOutputStream os = null;
		try {
			os = new ObjectOutputStream(new FileOutputStream("object_out.txt"));
			Person person = new Person("白娘子", 1000);
			os.writeObject(person);

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
			os = new ObjectInputStream(new FileInputStream("object_out.txt"));
			Person person =(Person)os.readObject();//反序列化的时候，并没有调用Person类的构造方法
			System.out.println("名字："+person.getName()+";年龄:"+person.getAge());

		} catch (IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
