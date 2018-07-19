package com.ks0100_1;

/*
 * 字符串转换
 */
public class StringTest5 {

	public static void main(String[] args) {
		// 定义一个字符串对象
		String s = "JavaSE";
		
		// byte[] getBytes():把字符串转换为字节数组。
		System.out.println("用getBytes()方法把字符串\"JavaSE\"转换为字节数组。");
		byte[] bys = s.getBytes();
		for (int x = 0; x < bys.length; x++) {
			System.out.print(" "+bys[x]);
		}
		System.out.println("----------------");

		// char[] toCharArray():把字符串转换为字符数组。
		System.out.println("用toCharArray()方法把字符串\"JavaSE\"转换为字符数组。");
		char[] chs = s.toCharArray();
		for (int x = 0; x < chs.length; x++) {
			System.out.print(" "+chs[x]);
		}
		System.out.println("----------------");

		// static String valueOf(char[] chs):把字符数组转成字符串。
		System.out.println("用 String.valueOf(...)方法把上面字符数组转为字符串");
		
		String ss = String.valueOf(chs);//String ss=new String(chs);
		System.out.println(ss);
		System.out.println("----------------");

		// static String valueOf(int i):把int类型的数据转成字符串。
		System.out.println("用 String.valueOf(...)方法把整数100转为字符串");
		int i = 100;
		String sss = String.valueOf(i);
		System.out.println(sss);
		System.out.println("----------------");

		// String toLowerCase():把字符串转成小写。
		System.out.println("把\"JavaSE\" 转为小写");
		System.out.println("toLowerCase:" + s.toLowerCase());
		System.out.println("s:" + s);
		// System.out.println("----------------");
		// String toUpperCase():把字符串转成大写。
		System.out.println("把\"JavaSE\" 转为大写");
		System.out.println("toUpperCase:" + s.toUpperCase());
		System.out.println("----------------");

		// String concat(String str):把字符串拼接。
		String s1 = "hello";
		String s2 = "world";
		String s3 = s1 + s2;
		String s4 = s1.concat(s2);//和运算符 + 是一样的
		System.out.println("s3:" + s3);
		System.out.println("s4:" + s4);
		
	}

}
