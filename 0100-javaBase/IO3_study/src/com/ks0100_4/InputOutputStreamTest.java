package com.ks0100_4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InputOutputStreamTest {

	public static void main(String[] args) throws IOException{
		System.out.println("用FileReader和BufferedReader 来读文件。。。。。");
		read("古诗.txt");//古诗.txt是用gbk保存的，而我们这个eclipse环境是用utf-8来编译的，那么流读取的环境也是utf-8，所以当然乱码了
		System.out.println("用FileReader和BufferedReader 来读文件。。。。。");
		read("古诗.txt","gbk");//可以用utf-8来读吗？
	}
	
	public static void read(String filename) throws IOException {
		/**
		 * 使用缓冲区 可以使用缓冲区对象的 read() 和 readLine()方法。
		 */
		
		// 创建字符流缓冲区
		BufferedReader bufr = new BufferedReader(new FileReader(filename));// 缓冲

		String line;
		while ((line = bufr.readLine()) != null) {
			System.out.println(line);
		}
		bufr.close();
	}
	
	//这里只举了InputStreamReader的例子，大家自学OutputStreamWriter，学习怎么写数据，采用一定的编码格式，如gbk
	public static void read(String filename, String charsetName) throws IOException {
		// 读取文件上的字节流数据。
		InputStream in = new FileInputStream(filename);
		// 将字节流向字符流的转换。
		InputStreamReader isr = new InputStreamReader(in,charsetName);//指定用什么字符编码来读取流
		// 用BufferedReader在包装一下，做缓冲提高效率
		BufferedReader bufr = new BufferedReader(isr);

		String line;
		while ((line = bufr.readLine()) != null) {
			System.out.println(line);
		}
		isr.close();
	}
}
