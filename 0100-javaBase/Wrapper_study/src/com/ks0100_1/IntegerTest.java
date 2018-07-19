package com.ks0100_1;

public class IntegerTest {

	public static void main(String[] args) {
		
		System.out.println("十进制100转二进制："+Integer.toBinaryString(100));
		System.out.println("十进制100转八进制："+Integer.toOctalString(100));
		System.out.println("十进制100转十六进制："+Integer.toHexString(100));
		System.out.println("*******Integer.toString(int i, int radix)方法 转进制");
		// 十进制到其他进制
		System.out.println("十进制100："+Integer.toString(100, 10));
		System.out.println("十进制100转二进制："+Integer.toString(100, 2));
		System.out.println("十进制100转八进制："+Integer.toString(100, 8));
		System.out.println("十进制100转十六进制："+Integer.toString(100, 16));
		System.out.println("十进制100转7进制："+Integer.toString(100, 7));
		System.out.println("十进制100转-7进制："+Integer.toString(100, -7));
		
		System.out.println("*******其他进制到十进制********");
		//其他进制到十进制
		System.out.println("十进制100："+Integer.parseInt("100", 10));
		System.out.println("二进制100转十进制："+Integer.parseInt("100", 2));
		System.out.println("二进制100转八进制："+Integer.parseInt("100", 8));
		System.out.println("二进制100转十六进制："+Integer.parseInt("100", 16));
		System.out.println("二进制100转23进制："+Integer.parseInt("100", 23));
		//System.out.println(Integer.parseInt("123", 2));//NumberFormatException
		//int类型4个字节32位，有符号，从-2^31--2^31
		System.out.println("int最大值:"+Integer.MAX_VALUE);
		System.out.println("int最小值:"+Integer.MIN_VALUE);
	}

}
