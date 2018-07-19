package com.ks0100_1;

public class StringTest2 {

	public static void main(String[] args) {
		System.out.println("---------练习String类的split()方法分隔字符串------------");
		// 定义一个字符串
		System.out.println("把字符串aa,bb,cc分隔，按照,");
		String s1 = "aa,bb,cc";
		// 直接分割
		String[] str1Array = s1.split(",");
		for (int x = 0; x < str1Array.length; x++) {
			System.out.println(str1Array[x]);
		}
		System.out.println("---------------------");

		System.out.println("把字符串aa.bb.cc分隔，按照,");
		String s2 = "aa.bb.cc";
		String[] str2Array = s2.split("\\.");// \.转义成普通字符的.
		// String[] str2Array = s2.split(".");//.是正则表达式，所以分不出来
		for (int x = 0; x < str2Array.length; x++) {
			System.out.println(str2Array[x]);
		}
		System.out.println("---------------------");

		System.out.println("把字符串aa    bb                cc分隔，按照空格,");
		String s3 = "aa    bb                cc";
		String[] str3Array = s3.split(" +");
		// String[] str3Array = s3.split(" \\s+");// \s也是空格的意思，这样更好理解
		for (int x = 0; x < str3Array.length; x++) {
			System.out.println(str3Array[x]);
		}
		System.out.println("---------------------");

		System.out.println("把字符串E:\\JavaSE\\day14\\avi 按照\\分隔");
		String s4 = "E:\\JavaSE\\day14\\1.avi";
		// 因为在java中\\表示一个\，而regex中\\也表示\，所以当\\\\解析成regex的时候为\\。
		String[] str4Array = s4.split("\\\\");// 我们最终的正则表达式需要输入
												// \\，表示转义成普通字符\，用\来分隔
		for (int x = 0; x < str4Array.length; x++) {
			System.out.println(str4Array[x]);
		}
		System.out.println("---------------------");

		System.out.println("---------练习String类的replaceALL()方法分隔字符串------------");
		
		System.out.println("把字符串helloqq12345worldkh622112345678java 中所有数字用*代替:");

		// 我要去除所有的数字,用*给替换掉
		//String regex = "\\d";//每个数字替换一个*
		String regex = "\\d+";//数字连在一起替换成一个*
		String s="helloqq12345worldkh622112345678java";
		String result = s.replaceAll(regex,"*" );
		System.out.println(result);
		
		System.out.println("---------练习String类的replaceFirst()方法分隔字符串------------");
		String[] msgs={
				"Java has regular regular expressions in 1.4",
				"regular expressions now expressing in Java",
				"Java represses oracular expressions"
		};
		
		System.out.println(msgs[0]);
		System.out.println(msgs[1]);
		System.out.println(msgs[2]);
		System.out.println("----------把上面字符串中每一行的第一个re开头的字母替换掉成为 ‘哈哈’：------------");
		for(String msg:msgs){
			System.out.println(msg.replaceFirst("re\\w*", "哈哈"));// \w表示字母和数字，不包括空格
		}
	}

}
