package com.ks0100_3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeTest5 {
	public static void main(String[] args) {
		ObjectOutputStream out = null;
		ObjectInputStream in=null;
		try {
			//序列化
			out = new ObjectOutputStream(new FileOutputStream("serializeTest5_out.txt"));
			
			out.writeObject(Orientation2.HORIZONTAL);
			
			System.out.println("开始反序列化--------");
			//反序列化
			in = new ObjectInputStream(new FileInputStream("serializeTest5_out.txt"));
			Orientation2 orientation2=(Orientation2)in.readObject();
			System.out.println("value:"+orientation2.getValue());
			
			System.out.println("orientation2==Orientation2.HORIZONTAL:"+(orientation2==Orientation2.HORIZONTAL));
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
