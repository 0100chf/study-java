package com.ks0100_1;

/*
 * 字符串判断
 */
public class StringTest3 {

	public static void main(String[] args) {
		// 创建字符串对象
		String s1 = "helloworld";
		String s2 = "helloworld";
		String s3 = "HelloWorld";

		// boolean equals(Object obj):比较字符串的内容是否相同,区分大小写
		System.out.println("s1 s2 equals:" + s1.equals(s2));
		System.out.println("s1 s3 equals:" + s1.equals(s3));
		System.out.println("-----------------------");

		// boolean equalsIgnoreCase(String str):比较字符串的内容是否相同,忽略大小写
		System.out.println("s1 s2 equalsIgnoreCase:" + s1.equalsIgnoreCase(s2));
		System.out.println("s1 s3 equalsIgnoreCase:" + s1.equalsIgnoreCase(s3));
		System.out.println("-----------------------");

		// boolean contains(String str):判断大字符串中是否包含小字符串
		System.out.println("s1 contains:" + s1.contains("hello"));
		System.out.println("s1 contains:" + s1.contains("hw"));
		System.out.println("-----------------------");

		// boolean startsWith(String str):判断字符串是否以某个指定的字符串开头
		System.out.println("s1 startsWith \"h\":" + s1.startsWith("h"));
		System.out.println("s1 startsWith \"hello\":" + s1.startsWith("hello"));
		System.out.println("s1 startsWith \"world\":" + s1.startsWith("world"));
		System.out.println("-----------------------");

		// 练习：boolean endsWith(String str):判断字符串是否以某个指定的字符串结尾这个自己玩

		// boolean isEmpty():判断字符串是否为空。
		System.out.println("s1 isEmpty:" + s1.isEmpty());

		String s4 = "";
		String s5 = null;
		System.out.println("s4 isEmpty:" + s4.isEmpty());
		// NullPointerException
		// s5对象都不存在，所以不能调用方法，空指针异常
//		System.out.println("s5 isEmpty:" + s5.isEmpty());
		
		String s6=new String();
		System.out.println("s6 isEmpty:" + s6.isEmpty());
	}

}
