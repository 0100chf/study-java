package com.ks0100_1;

/*
 * 这个类讲字符串截取
 */
public class StringTest4 {

	public static void main(String[] args) {
		// 定义一个字符串对象
		String s = "helloworld";

		// int length():获取字符串的长度。
		System.out.println("s.length:" + s.length());
		System.out.println("----------------------");

		// char charAt(int index):获取指定索引位置的字符
		System.out.println("helloworld charAt 7:" + s.charAt(7));
		System.out.println("----------------------");

		// int indexOf(int ch):返回指定字符在此字符串中第一次出现处的索引。
		System.out.println("helloworld indexOf l:" + s.indexOf('l'));
		System.out.println("----------------------");

		// int indexOf(String str):返回指定字符串在此字符串中第一次出现处的索引。
		System.out.println("helloworld indexOf owo:" + s.indexOf("owo"));
		System.out.println("----------------------");

		// int indexOf(int ch,int fromIndex):返回指定字符在此字符串中从指定位置后第一次出现处的索引。
		System.out.println("l 从索引3以后，helloworld在第一次出现的索引  indexOf:" + s.indexOf('l', 3));
		System.out.println("l 从索引4以后，helloworld在第一次出现的索引  indexOf:" + s.indexOf('l', 4));
		System.out.println("k 从索引4以后，helloworld在第一次出现的索引  indexOf:" + s.indexOf('k', 4)); // -1
		System.out.println("l 从索引40以后，helloworld在第一次出现的索引  indexOf:" + s.indexOf('l', 40)); // -1
		System.out.println("----------------------");

		// 自己练习：int indexOf(String str,int fromIndex):返回指定字符串在此字符串中从指定位置后第一次出现处的索引。

		// String substring(int start):从指定位置开始截取字符串,默认到末尾。包含start这个索引
		System.out.println("helloworld substring 从索引5开始:" + s.substring(5));
		System.out.println("helloworld substring 从索引0开始:" + s.substring(0));//从头开始
		System.out.println("----------------------");

		// String substring(int start,int end):从指定位置开始到指定位置结束截取字符串。包括start索引但是不包end索引
		System.out.println("helloworld substring 3~(8-1)的索引对应字符:" + s.substring(3, 8));
		System.out.println("helloworld substring 整个字符串:" + s.substring(0, s.length()));
	}

}
