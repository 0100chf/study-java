package com.ks0100_3;

import java.io.*;

//编写程序，提示用户输入两个字符串，并检验第一个串是否为第二个串的子串。
public class Test2 {
	public static void main(String[] args) throws IOException {
		BufferedReader b = 
				new BufferedReader(new InputStreamReader(System.in));
		String s1, s2;
		System.out.println("请输入两个字符串：");
		s1 = b.readLine();
		s2 = b.readLine();
		int pos = s2.indexOf(s1);
		if (pos < 0)
			System.out.println(s1 + "不是" + s2 + "的子串！ ");
		else
			System.out.println(s1 + "是" + s2 + "的子串！ ");
	}

}
