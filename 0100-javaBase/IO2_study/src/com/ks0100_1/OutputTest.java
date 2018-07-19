package com.ks0100_1;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 现在需要往文件里面写文字，从内存往文件的方向，就是输出流，用OutputStream和Writer
 * 
 */
public class OutputTest {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("writeIn.txt");//看源码，没有文件，会自动创建文件
		
		String s="Java作为最主流的编程语言，长期以来一直处于全球编程语言排行榜的领先位置，在应用层，没有任何一个语言可以和Java抗衡。\n"
				+"据统计，全球运行JAVA程序的设备已经超过30亿个，在服务器领域、移动设备、桌面应用和Web领域JAVA都占据着重要地位。\n"
				+"今天，Java运行在9.08亿手机、10亿智能卡和10亿PC上，Java已经在服务器端也占领了绝大部分市场，在Android系统上获得了广泛的应用，在大数据领域也成为很多软件的底层语言。";
		fos.write(s.getBytes());
		fos.close();
		
		FileWriter  fw = new FileWriter ("writeIn2.txt");
		fw.write(s);
		fw.close();
	}
}
