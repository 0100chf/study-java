package com.ks0100_3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializeTest3 {
	public static void main(String[] args) {
		ObjectOutputStream out = null;
		ObjectInputStream in=null;
		try {
			//序列化
			out = new ObjectOutputStream(new FileOutputStream("serializeTest3_out.txt"));
			Person3 person = new Person3("孙悟空", 600);
			out.writeObject(person);//在序列化的时候，其实不是序列化对象，而是运行writeReplace()里面的方法
			System.out.println("开始反序列化--------");
			//反序列化
			in = new ObjectInputStream(new FileInputStream("serializeTest3_out.txt"));
			ArrayList list=(ArrayList)in.readObject();
			System.out.println("list:"+list);
			//以下会出现异常，因为对象没有被序列化，而是把ArrayList对象序列化
//			Person3 p1=(Person3)in.readObject();
//			System.out.println("姓名:"+p1.getName()+";年龄:"+p1.getAge());
			
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
