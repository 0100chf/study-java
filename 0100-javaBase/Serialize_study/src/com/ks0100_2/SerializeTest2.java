package com.ks0100_2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SerializeTest2 {

	public static void main(String[] args) {
		ObjectOutputStream out = null;
		ObjectInputStream in=null;
		try {
			//序列化
			out = new ObjectOutputStream(new FileOutputStream("error_out.txt"));
			
			Person person = new Person("孙悟空", 600);
			person.setSex("男");
			out.writeObject(person);
			person.setName("猪八戒");
			person.setSex("女");
			out.writeObject(person);//写的是序列化编号，不是字节序列，所以不会输出Field值
			//反序列化
			in = new ObjectInputStream(new FileInputStream("error_out.txt"));
			Person p1=(Person)in.readObject();
			Person p2=(Person)in.readObject();
			System.out.println("p1==p2:"+(p1==p2));
			System.out.println("p1.name="+p1.getName()+";p2.name="+p2.getName());//改变不了Field值
			/*
			 * sex之所以会改变，是因为static 修饰的变量是不是属于对象，是属于类,保存在常量池里.
			 * 所以static 修饰的Field是没有被序列化到字节序列中的
			 */
			System.out.println("p1.sex="+p1.getSex()+";p2.sex="+p2.getSex());
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
