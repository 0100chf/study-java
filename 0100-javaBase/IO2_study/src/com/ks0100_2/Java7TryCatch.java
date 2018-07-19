package com.ks0100_2;

import java.io.FileInputStream;
import java.io.IOException;

//该类必须在java7以上编译
public class Java7TryCatch {

	public static void main(String[] args) {
		
		//看源码知道 InputStream implements Closeable ，实现close()方法，所以不要自己关闭close()方法了
//		try (FileInputStream fis = new FileInputStream("java.txt")) {
//			
//			System.out.println("FileInputStream 读取-----------:");
//			int by = fis.read();
//			System.out.println(by);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}

}
