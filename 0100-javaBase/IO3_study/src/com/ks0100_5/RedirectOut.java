package com.ks0100_5;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class RedirectOut {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps=new PrintStream(new FileOutputStream("redirectOut.txt"));
		
		System.setOut(ps);//本来下面方法应该在屏幕上打印文件，但是重定向"标准"输出流，现在流输出到文件
		System.out.println("普通字符串");
		System.out.println("原来输出到屏幕，现在输出到文件redirectOut.txt");
	}

}
