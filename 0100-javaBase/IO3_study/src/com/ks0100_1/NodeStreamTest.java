package com.ks0100_1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class NodeStreamTest {

	public static void main(String[] args) throws IOException {
		stringNodeStream();
		//二进制数组流，功能很强大，可以操作任何类型的数据。
		byteArrayInputStream();
		byteArrayOutputStream();
		charArrayReader();
		charArrayWriter();
	}

	public static void stringNodeStream() throws IOException {
		System.out.println("stringNodeStream()------------------");
		String src = "黄河远上白云间， \n" 
				+ "一片孤城万仞山。\n" 
				+ "羌笛何须怨杨柳，\n " 
				+ "春风不度玉门关。\n";
		StringReader sr = new StringReader(src);
		// 把字符src内容用StringReader输入到字符串节点里
		int len = 0;
//		while ((len = sr.read()) > 0) {//读取每个字符然后‘输出’(打印)，低效
//			System.out.print((char) len);
//		}
		char[] buf=new char[32];//用缓冲，高效
		while ((len = sr.read(buf)) > 0) {
			System.out.print(new String(buf,0,len));
		}
		sr.close();
		System.out.println("用字符串节点流输出-------");
		StringWriter sw=new StringWriter();
		sw.write("黄河远上白云间， \n");
		sw.write("一片孤城万仞山。\n");
		sw.write("羌笛何须怨杨柳，\n");
		sw.write("春风不度玉门关。\n");
		System.out.println(sw);
		sw.close();
	}
	
	
	public static void byteArrayInputStream() throws IOException {
		System.out.println("byteArrayInputStream()------------------");
		String src = "黄河远上白云间，\n" 
				+ "一片孤城万仞山。\n" 
				+ "羌笛何须怨杨柳，\n" 
				+ "春风不度玉门关。\n";
		
		ByteArrayInputStream bi=new ByteArrayInputStream(src.getBytes());
		int len = 0;
		/*
		 	二进制转字符串不安全。
			出现乱码，因为是按照每32个字节去输入的，不能保证这首诗歌的所有汉字和标点的每个字符，都占两个字节，
			按照32个字节去截取，有可能在头和尾会截取一半，出现乱码
		 */
//		byte[] buf=new byte[32];
		byte[] buf=new byte[src.getBytes().length];//循环一次
		while ((len = bi.read(buf)) > 0) {
			System.out.print(new String(buf,0,len));
			System.out.println("--");
			//打开以下注释运行，就可以知道
//			System.out.println(new String(buf,0,len));
		}
		bi.close();
	}
	
	public static void byteArrayOutputStream() throws IOException {
		System.out.println("byteArrayOutputStream()------------------");
		ByteArrayOutputStream bo=new ByteArrayOutputStream();
		bo.write("黄河远上白云间，\n".getBytes());
		bo.write("一片孤城万仞山。\n".getBytes());
		bo.write("羌笛何须怨杨柳，\n".getBytes());
		bo.write("春风不度玉门关。\n".getBytes());
		System.out.println(bo.toString());
		bo.close();
	}
	
	public static void charArrayReader() throws IOException {
		System.out.println("charArrayReader()------------------");
		String src = "黄河远上白云间，\n" 
				+ "一片孤城万仞山。\n" 
				+ "羌笛何须怨杨柳，\n" 
				+ "春风不度玉门关。\n";
		
		CharArrayReader cr=new CharArrayReader(src.toCharArray());
		int len=0;
		char[] buf=new char[32];
		while ((len = cr.read(buf)) > 0) {
			System.out.print(new String(buf,0,len));
		}
		cr.close();
	}
	public static void charArrayWriter() throws IOException {
		System.out.println("charArrayWriter()------------------");
		CharArrayWriter cw=new CharArrayWriter();
		cw.write("黄河远上白云间，\n".toCharArray());
		cw.write("一片孤城万仞山。\n".toCharArray());
		cw.write("羌笛何须怨杨柳，\n".toCharArray());
		cw.write("春风不度玉门关。\n".toCharArray());
		System.out.println(cw.toString());
		cw.close();
	}
	
}
