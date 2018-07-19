package com.ks0100_4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataStreamTest {

	public static void main(String[] args) {
		try {
			FileOutputStream fos=new FileOutputStream("hello.txt");
			BufferedOutputStream bos=new BufferedOutputStream(fos);
			DataOutputStream dos=new DataOutputStream(bos);
			dos.writeUTF("ab中国1c");//按照utf编码写字符串
			dos.writeBytes("ab中国2c");//写成二进制，编码格式丢失
			dos.writeChars("ab中国3c");//写成字符串，编码格式丢失
			dos.close();
			System.out.println("开始读取--------");
			FileInputStream fis=new FileInputStream("hello.txt");
			BufferedInputStream bis=new BufferedInputStream(fis);
			DataInputStream dis=new DataInputStream(bis);
			System.out.println(dis.readUTF());
			byte[] buf=new byte[1024];
			int len=dis.read(buf);
			System.out.println(new String(buf,0,len));
			dis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
