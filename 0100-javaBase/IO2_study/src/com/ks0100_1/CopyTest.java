package com.ks0100_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyTest {

	public static void main(String[] args) {

		copy("java.txt", "./copy/java_copy.txt");
		copy("乔丹.jpg", "./copy/乔丹_copy.jpg");
		
		long current=System.currentTimeMillis();
		copy("我的天空.mp3", "./copy/我的天空_copy.mp3");//copy一个小文件要10几秒，太慢
		System.out.println("copy 我的天空.mp3 用时:"+(System.currentTimeMillis()-current)+"毫秒");
		
		long current2=System.currentTimeMillis();
		copy("我的天空.mp3", "./copy/我的天空_copy2.mp3",1024);
		System.out.println("用缓冲 copy 我的天空.mp3 用时:"+(System.currentTimeMillis()-current2)+"毫秒");
	}

	// 都是二进制文件，所以复制文件用字节流
	public static void copy(String source, String destination) {
		// 标准的 try catch语句，处理IO，catch 里面不能只打印，真正项目会写日志处理的。
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			// 封装数据源
			fis = new FileInputStream(source);

			// 封装目的地
			fos = new FileOutputStream(destination);

			int by = 0;
			// 读一个字节，写一个字节
			while ((by = fis.read()) != -1) {
				fos.write(by);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();// catch 里面不能只打印，真正项目会写日志处理的。
		} finally {
			// close 还要捕捉异常，挺麻烦的，但是不得不写
			try {
				// 释放资源(先关谁都行)
				fos.close();
				fis.close();
				System.out.println("复制"+source+"完毕.....");
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

		}
		
	}
	
	public static void copy(String source, String destination,int buffer) {
		// 标准的 try catch语句，处理IO，catch 里面不能只打印，真正项目会写日志处理的。
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			// 封装数据源
			fis = new FileInputStream(source);

			// 封装目的地
			fos = new FileOutputStream(destination);
			byte[] bys = new byte[buffer];//每次用byte缓冲，读取，提高效率
			int len = 0;
			// 读一个字节，写一个字节
			while ((len = fis.read(bys)) != -1) {
				fos.write(bys,0,len);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();// catch 里面不能只打印，真正项目会写日志处理的。
		} finally {
			// close 还要捕捉异常，挺麻烦的，但是不得不写
			try {
				// 释放资源(先关谁都行)
				fos.close();
				fis.close();
				System.out.println("复制"+source+"完毕.....");
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

		}
	}
}
