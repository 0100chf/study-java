package com.ks0100_3;

//从键盘输入一行字符，分别统计出其中英文字母、空格、数字和其他字符的个数，并将统计结果送到显示器上显示。
public class Test5 {
	public static void main(String args[]) {							
		byte[] c = new byte[100];
		int iChar, iNum, iSpace, iOther, i;
		iChar = iNum = iSpace = iOther = i = 0;
		try {													
			System.out.print("输入字符串：");
			System.in.read(c);
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		while(c[i] != 0) {										
			if(Character.isLetter((char)c[i]))						
				iChar ++;
			else if (Character.isDigit((char)c[i]))
				iNum++;
			else if(Character.isSpace((char)c[i]))
				iSpace++;
			else
				iOther++;
			i++;
		}
		System.out.println("There are " + iChar + " charaters.");		
		System.out.println("There are " + iNum + " numbers.");
		System.out.println("There are " + iSpace + " space.");
		System.out.println("There are " + iOther + " others.");
	}
}
