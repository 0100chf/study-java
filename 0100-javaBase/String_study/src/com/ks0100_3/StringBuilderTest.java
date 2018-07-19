package com.ks0100_3;

/*
 * StringBuilder的构造方法和append()方法
 */
public class StringBuilderTest {

	public static void main(String[] args) {
		// public StringBuilder():无参构造方法
		System.out.println("无参构造方法");
		StringBuilder sb = new StringBuilder();
		System.out.println("sb:" + sb);
		System.out.println("sb.capacity():" + sb.capacity());
		System.out.println("sb.length():" + sb.length());
		System.out.println("--------------------------");

		// public StringBuilder(int capacity):指定容量的字符串缓冲区对象
		// 看API：public int capacity()：容量指可用于最新插入字符的存储量，超过这一容量便需要再次分配。
		System.out.println("用 public StringBuilder(int capacity)构造:指定容量的字符串缓冲区对象");
		StringBuilder sb2 = new StringBuilder(50);
		System.out.println("sb2:" + sb2);
		System.out.println("容量 sb2.capacity():" + sb2.capacity());
		System.out.println("字符长度 sb2.length():" + sb2.length());
		System.out.println("--------------------------");

		// public StringBuilder(String str):指定字符串内容的字符串缓冲区对象
		System.out.println("用 public StringBuilder(String str)构造:指定字符串内容的字符串缓冲区对象");
		StringBuilder sb3 = new StringBuilder("hello");
		System.out.println("sb3:" + sb3);
		System.out.println("sb3.capacity():" + sb3.capacity());
		System.out.println("sb3.length():" + sb3.length());

		System.out.println("----------下面开始拼接字符串---------");

		// 创建字符串缓冲区对象
		StringBuilder sb4 = new StringBuilder();

		// 一步一步的添加数据
		sb4.append("hello");
		sb4.append(true);
		sb4.append(12);
		sb4.append(34.56);
		// 也可以 链式编程
		sb4.append("hello").append(true).append(12).append(34.56);
		System.out.println("sb4:" + sb4);

		StringBuilder sb5 = sb4.append("hello");
		System.out.println("sb4:" + sb4);
		System.out.println("sb5:" + sb5);
		System.out.println("sb4 == sb5:"+(sb4 == sb5)); // true


	}

}
