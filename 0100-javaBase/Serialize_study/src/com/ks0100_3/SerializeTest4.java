package com.ks0100_3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeTest4 {

	public static void main(String[] args) {
		ObjectOutputStream out = null;
		ObjectInputStream in=null;
		try {
			//序列化
			out = new ObjectOutputStream(new FileOutputStream("serializeTest4_out.txt"));
			
			out.writeObject(Orientation.HORIZONTAL);
			
			System.out.println("开始反序列化--------");
			//反序列化
			in = new ObjectInputStream(new FileInputStream("serializeTest4_out.txt"));
			Orientation orientation=(Orientation)in.readObject();
			System.out.println("value:"+orientation.getValue());
			//Field用static修饰，那么序列化后就不是引用一个对象了，要解决这个问题，必须实现特殊签名方法readResolve(...)
			System.out.println("orientation==Orientation.HORIZONTAL:"+(orientation==Orientation.HORIZONTAL));
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
