package com.ks0100_1;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/*
 * 前面讲过怎么对文件和文件夹的操作
 * 现在需要读取文件里面的内容，那么往内存方向的，就是输入流，用FileInputStream 和FileReader 
 * 
 */
public class InputTest {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("java.txt");

		System.out.println("FileInputStream 第一次读取-----------:");
		int by = fis.read();
		System.out.println(by);
		System.out.println((char) by);
		System.out.println("FileInputStream 第二次读取------------:");
		by = fis.read();
		System.out.println((char) by);

		//用循环读取,如果你读取的数据是-1，就说明已经读取到文件的末尾了
		while (by != -1) {
			by = fis.read();
			//出现乱码原因是字节流每次只读取一个字节，
			//英文字符都是按照ASCII编码，占一个字节， java中文字符是占两个字节的，所以输出中文乱码
			System.out.print((char) by);
		}
		
		fis.close();// IO资源不属于java内存资源，所以要释放资源
		
		FileReader fr = new FileReader("java.txt");
		System.out.println("第一次读取-----------:");
		int ch=fr.read();
		System.out.println(ch);
		System.out.println((char) ch);
		System.out.println("循环读取----------:");
		while (ch != -1) {
			ch = fr.read();
			System.out.print((char) ch);
		}
		fr.close();// 释放资源
		
		fr= new FileReader("java.txt");
		char[] chars=new char[4];
		fr.read(chars);
		System.out.println("\n读取开头4个字符----------:");
		System.out.println(String.valueOf(chars));
		fr.close();// 释放资源
		
		fr= new FileReader("java.txt");
		char[] chars2=new char[8];
		fr.read(chars2,0 , chars2.length);
		System.out.println("\n读取开头8个字符----------:");
		System.out.println(String.valueOf(chars2));
		fr.close();// 释放资源
		
		fr= new FileReader("java.txt");
		char[] chars3=new char[32];
		int hasRead=0;
		System.out.println("\n把流放到字符缓冲区，遍历读取----------:");//这种方式遍历读取，效率要比一个一个读取效率高多了，空间换时间
		while( (hasRead=fr.read(chars3))>0 ){
			System.out.print(new String(chars3,0,hasRead));
		}
		fr.close();// 释放资源
		
		
		fis = new FileInputStream("java.txt");
		byte[] bys = new byte[1024];// 数组的长度一般是1024或者1024的整数倍
		int len = 0;
		System.out.println("\n把字节流放到byte缓存区，遍历读取：---------");
		while ((len = fis.read(bys)) != -1) {
			System.out.println(len);
			System.out.print(new String(bys, 0, len));//这样不会出现读取半个字节的情况
		}

		// 释放资源
		fis.close();
	}

}
