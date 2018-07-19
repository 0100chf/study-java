package com.ks0100_1;

public class CharacterTest {

	public static void main(String[] args) {
			Character ch = new Character('a');
			Character ch2 = new Character((char) 97);
			System.out.println("ch:" + ch+";ch2:"+ch2);
			
			// public static boolean isUpperCase(char ch):判断给定的字符是否是大写字符
			System.out.println("'A' 是大写字母:" + Character.isUpperCase('A'));
			System.out.println("'a' 是大写字母:" + Character.isUpperCase('a'));
			System.out.println("'0' 是大写字母:" + Character.isUpperCase('0'));
			System.out.println("-----------------------------------------");
			// public static boolean isLowerCase(char ch):判断给定的字符是否是小写字符
			System.out.println("'A' 是小写字母:" + Character.isLowerCase('A'));
			System.out.println("'a' 是小写字母:" + Character.isLowerCase('a'));
			System.out.println("'0' 是小写字母:" + Character.isLowerCase('0'));
			System.out.println("-----------------------------------------");
			// public static boolean isDigit(char ch):判断给定的字符是否是数字字符
			System.out.println("'A' 是数字:" + Character.isDigit('A'));
			System.out.println("'a' 是数字:" + Character.isDigit('a'));
			System.out.println("'0' 是数字:" + Character.isDigit('0'));
			System.out.println("-----------------------------------------");
			// public static char toUpperCase(char ch):把给定的字符转换为大写字符
			System.out.println("'A' 转成大写字母:" + Character.toUpperCase('A'));
			System.out.println("'a' 转成大写字母:" + Character.toUpperCase('a'));
			System.out.println("-----------------------------------------");
			// public static char toLowerCase(char ch):把给定的字符转换为小写字符
			System.out.println("'A' 转成小写字母:" + Character.toLowerCase('A'));
			System.out.println("'a' 转成小写字母:" + Character.toLowerCase('a'));
	}

}
